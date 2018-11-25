import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { Laudo, Diagnostico } from '../shared/adubacao/adubacao.model';
import { Subject } from 'rxjs';
@Component({
  selector: 'app-adubacao-edit',
  templateUrl: './adubacao-edit.component.html',
  styleUrls: ['./adubacao-edit.component.css']
})
export class AdubacaoEditComponent implements OnInit {
  public static MIN_VALUE = 0;
  public id: string;
  public title = 'Edição do Laudo';
  public diagnostico: Diagnostico;
  public isLoading: boolean;
  private ngUnsubscribe: Subject<void> = new Subject<void>();
  public form: FormGroup = this.fb.group({
    nome: ['', Validators.required],
    responsavel: ['', Validators.required],
    argila: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    pH: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    indiceSMP: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    fosforoP: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    potassioK: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    materiaOrganicaMO: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    aluminioTrocavelAlTroc: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    calcioTrocavelCaTroc: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    magnesioTrocavelMgTroc: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    aluminioHidrogenioALplusH: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    ctc: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    saturacaoCTCBase: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    saturacaoCTCAl: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    relacaoCaMg: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    relacaoCaK: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    relacaoMgK: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
    pHReferencia: ['', [Validators.required, Validators.min(AdubacaoEditComponent.MIN_VALUE)]],
  });
  constructor(
    private service: AdubacaoService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => { this.id = params['id']; });
    this.isLoading = true;
    this.service.get(this.id)
      .takeUntil(this.ngUnsubscribe)
      .do(() => this.isLoading = false)
      .subscribe((diagnostico: Diagnostico) => {
        this.diagnostico = Object.assign(new Diagnostico(), diagnostico);
        this.form.patchValue(new Laudo(this.diagnostico.laudo));
      });
  }
  public onSubmit(): void {
    this.isLoading = true;
    const laudoUpdate: Laudo = new Laudo(this.form.value);
    laudoUpdate.id = this.diagnostico.laudo.id;
    this.diagnostico.laudo = laudoUpdate;
    this.service.update(this.diagnostico)
      .take(1)
      .do(() => this.isLoading = false)
      .subscribe((res: string) => {
        this.id = res;
        this.redirect();
      });
  }
  private redirect(): void {
    this.router.navigate(['/adubacao-detail', this.id]);
  }

  private redirectBack(): void {
    this.router.navigate(['./']);
  }

}
