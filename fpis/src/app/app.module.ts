import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule, FormsModule, FormBuilder } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent} from './header/header.component';
import { KupacComponent } from './kupac/kupac.component';
import { PonudaComponent } from './ponuda/ponuda.component';
import { PretragaPonudeComponent } from './ponuda/pretraga-ponude/pretraga-ponude.component';
import { HomeComponent} from './home/home.component';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DijalogIzmenaComponent } from './dijalog-izmena/dijalog-izmena.component';
import { DijalogVerComponent } from './dijalog-ver/dijalog-ver.component';
import { FilterPipe } from './ponuda/pretraga-ponude/filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    KupacComponent,
    PonudaComponent,
    PretragaPonudeComponent,
    HomeComponent,
    DijalogIzmenaComponent,
    DijalogVerComponent,
    FilterPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    MatDialogModule,
    BrowserAnimationsModule,
  ],
  providers: [
    FormBuilder,
    {
      provide: MatDialogRef,
      useValue: {}
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
