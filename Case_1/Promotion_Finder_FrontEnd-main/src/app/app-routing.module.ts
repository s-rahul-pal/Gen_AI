import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './module/user/home/home.component';
import { PromotionComponent } from './module/user/promotion/promotion.component';

const routes: Routes = [
  {path:'user',loadChildren:()=>import('./module/user/user.module').then(m=>m.UserModule)},
    {path:'',redirectTo:'user',pathMatch:'full'},
    
    {path:'home',component:HomeComponent},
    {path:'promotion', component:PromotionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
