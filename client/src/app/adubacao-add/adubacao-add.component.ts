import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { Laudo } from '../shared/adubacao/adubacao.model';

@Component({
  selector: 'app-adubacao-add',
  templateUrl: './adubacao-add.component.html',
  styleUrls: ['./adubacao-add.component.css']
})
export class AdubacaoAddComponent {
  public static MIN_VALUE = 0;
  public id = 0;
  public title = 'Cadastro do Laudo';
  public isLoading: boolean;
  public form: FormGroup = this.fb.group({
    nome: ['', Validators.required],
    responsavel: ['', Validators.required],
    argila: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    pH: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    indiceSMP: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    fosforoP: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    potassioK: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    materiaOrganicaMO: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    aluminioTrocavelAlTroc: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    calcioTrocavelCaTroc: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    magnesioTrocavelMgTroc: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    aluminioHidrogenioALplusH: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    ctc: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    saturacaoCTCBase: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    saturacaoCTCAl: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    relacaoCaMg: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    relacaoCaK: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    relacaoMgK: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
    pHReferencia: ['', [Validators.required, Validators.min(AdubacaoAddComponent.MIN_VALUE)]],
  });
  constructor(
      private service: AdubacaoService,
      private fb: FormBuilder,
      private router: Router) { }

  public onSubmit(): void {
      this.isLoading = true;
      const adubacaoAdd: Laudo = new Laudo(this.form.value);
      this.service.add(adubacaoAdd)
          .take(1)
          .do(() => this.isLoading = false)
          .subscribe((res: number) => {
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
