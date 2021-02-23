import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KupacComponent } from './kupac/kupac.component';
import { PonudaComponent } from './ponuda/ponuda.component';
import { PretragaPonudeComponent } from './ponuda/pretraga-ponude/pretraga-ponude.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: 'kupac',
        component: KupacComponent
      },
      {
        path: 'ponuda',
        component: PonudaComponent
      },
      {
        path: 'ponuda/pretraga-ponude',
        component: PretragaPonudeComponent
      },
      {
        path: 'ponuda/:id',
        component: PonudaComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
