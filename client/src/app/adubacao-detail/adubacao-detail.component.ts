import { Component, OnInit, OnDestroy } from '@angular/core';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { Subject } from 'rxjs/Subject';
import { Router, ActivatedRoute } from '@angular/router';
import { Diagnostico } from '../shared/adubacao/adubacao.model';

@Component({
  selector: 'app-adubacao-detail',
  templateUrl: './adubacao-detail.component.html',
  styleUrls: ['./adubacao-detail.component.css']
})
export class AdubacaoDetailComponent implements OnInit, OnDestroy {
  public id: number;
  public diagnostico: Diagnostico;
  public isLoading: boolean;
  private ngUnsubscribe: Subject<void> = new Subject<void>();
  constructor(private service: AdubacaoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => { this.id = +params['id']; });
    this.isLoading = true;
    this.service.get(this.id)
      .takeUntil(this.ngUnsubscribe)
      .do(() => this.isLoading = false)
      .subscribe((diagnostico: Diagnostico) => {
        this.diagnostico = Object.assign(new Diagnostico(), diagnostico);
      });
  }

  private redirect(): void {
    this.router.navigate(['/adubacao-edit', this.id]);
  }

  private redirectBack(): void {
    this.router.navigate(['./']);
  }
  public ngOnDestroy(): void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

}
