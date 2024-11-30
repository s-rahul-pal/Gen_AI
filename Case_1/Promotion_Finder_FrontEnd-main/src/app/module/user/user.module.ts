import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { PromotionComponent } from './promotion/promotion.component';
import { TestComponent } from './test/test.component';
import { PaginatorComponent } from './paginator/paginator.component';


@NgModule({
  declarations: [
    DashboardComponent,
    HomeComponent,
    PromotionComponent,
    TestComponent,
    PaginatorComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule
  ]
})
export class UserModule { }
