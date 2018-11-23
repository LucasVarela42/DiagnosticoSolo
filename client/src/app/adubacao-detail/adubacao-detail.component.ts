import { Component, OnInit, OnDestroy } from '@angular/core';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { Subject } from 'rxjs/Subject';
import { Router, ActivatedRoute } from '@angular/router';
import { Diagnostico, Laudo, Laudo, Laudo } from '../shared/adubacao/adubacao.model';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-adubacao-detail',
  templateUrl: './adubacao-detail.component.html',
  styleUrls: ['./adubacao-detail.component.css']
})
export class AdubacaoDetailComponent implements OnInit, OnDestroy {
    displayedColumns: string[] = ['id', 'nome', 'responsavel'];
  dataSource = new MatTableDataSource<any>();
    public id: number;
    public diagnostico: Diagnostico;
    public laudo: Laudo;
    public isLoading: boolean;
    private ngUnsubscribe: Subject<void> = new Subject<void>();
    constructor(private service: AdubacaoService, private router: Router, private route: ActivatedRoute) { }

    ngOnInit() {
        this.route.params.subscribe(params => { this.id = +params['id']; });
        this.isLoading = true;
        this.service.get(this.id)
            .takeUntil(this.ngUnsubscribe)
            .do(() => this.isLoading = false)
            .subscribe((diagnostico: any) => {
                this.diagnostico = Object.assign(new Diagnostico(), diagnostico);
                this.laudo = new Laudo(diagnostico.laudo);
                this.dataSource.data = diagnostico;
                console.log(this.laudo);
            });
    }

    public redirect(): void {
        this.router.navigate(['./']);
    }

    public ngOnDestroy(): void {
        this.ngUnsubscribe.next();
        this.ngUnsubscribe.complete();
    }

}
