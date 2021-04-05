import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SignupComponent } from './views/auth/signup/signup.component';
import { ProfileComponent } from './views/admin/profile/profile.component';
import { AuthComponent } from './layouts/auth/auth.component';
import { AdminComponent } from './layouts/admin/admin.component';
import { LoginComponent } from './views/auth/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    ProfileComponent,
    AuthComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
