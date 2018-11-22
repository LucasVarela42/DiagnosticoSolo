import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';

@Component({
  selector: 'app-laudo-edit',
  templateUrl: './laudo-edit.component.html',
  styleUrls: ['./laudo-edit.component.css']
})
export class LaudoEditComponent implements OnInit, OnDestroy {
  laudo: any = {};
  sub: Subscription;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private adubacaoService: AdubacaoService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.adubacaoService.get(id).subscribe((laudo: any) => {
          if (laudo) {
            this.laudo = laudo;
            this.laudo.href = laudo._links.self.href;
          } else {
            console.log(`Car with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/laudo-list']);
  }

  save(form: NgForm) {
    this.adubacaoService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.adubacaoService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

}
