import { Component } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Promotion } from 'src/app/model/Promotion';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent {
  promotions: Promotion[] = [];
  valuevalue: any;
  showModal: boolean = false;
  showModal2: boolean = false;
  itemsPerPage = 5;
  currentPage: number = 1;
  countries: string[] = [];
  termsOfUse: string[] = [];
  locations: string[] = [];

  constructor(private httpClient: HttpClient) {
    this.httpClient.get(environment.locationApiUrl + "/countries").subscribe((res: any) => {
      this.countries = res;
    });
  }

  ngOnInit() {}

  get pagedEnergyData() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.promotions.slice(startIndex, endIndex);
  }
  getValue(value: any) {
    console.log(value.target.value);
    this.valuevalue = value.target.value;
    this.httpClient.get<Promotion[]>(environment.promotionApiUrl + "/" + this.valuevalue).subscribe((res: any) => {
      this.promotions = res;
      console.log(this.promotions);
    });
  }

  onPageChange(newPage: number) {
    this.currentPage = newPage;
  }

  openModal(yourdata: any) {
    this.showModal = true;
    this.termsOfUse = yourdata;
  }

  openLocationModal(yourdata: any) {
    this.showModal2 = true;
    this.locations = yourdata;
  }

  closeModal() {
    this.showModal = false;
    this.showModal2 = false;
  }
}
