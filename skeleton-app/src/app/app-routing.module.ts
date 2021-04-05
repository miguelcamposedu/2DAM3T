import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './layouts/auth/auth.component';
import { LoginComponent } from './views/auth/login/login.component';
import { SignupComponent } from './views/auth/signup/signup.component';

const routes: Routes = [
  { 
    path: "auth", 
    component: AuthComponent, 
    children: [
      { path: "login", component: LoginComponent },
      { path: "signup", component: SignupComponent },
      { path: "", redirectTo: "login", pathMatch: "full" }
    ]
  },
  { path: "", redirectTo: "auth", pathMatch: "full" },
  { path: "**", redirectTo: "auth", pathMatch: "full" },
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
