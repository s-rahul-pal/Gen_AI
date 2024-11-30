import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PromotionFinderPageComponent } from './promotion-finder-page/promotion-finder-page.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'promotion',component:PromotionFinderPageComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ModuleRoutingModule { }
