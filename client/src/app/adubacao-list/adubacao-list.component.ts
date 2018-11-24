import { AdubacaoDeleteDialogComponent } from './adubacao-delete-dialog/adubacao-delete-dialog.component';
import { Component, OnInit } from '@angular/core';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { MatTableDataSource, MatDialog } from '@angular/material';
import { Diagnostico } from '../shared/adubacao/adubacao.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-adubacao-list',
  templateUrl: './adubacao-list.component.html',
  styleUrls: ['./adubacao-list.component.css']
})
export class AdubacaoListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'responsavel', 'open', 'edit', 'delete'];
  dataSource = new MatTableDataSource<any>();
  selected: Diagnostico = new Diagnostico();
  isLoading: boolean;

  constructor(private adubacaoService: AdubacaoService, private router: Router, private dialog: MatDialog) { }
  ngOnInit() {
    this.refresh();
  }

  public refresh() {
    this.isLoading = true;
    this.adubacaoService.getAll()
      .do(() => this.isLoading = false)
      .subscribe(data => {
        this.dataSource.data = data;
      });
  }

  public create() {
    this.router.navigate(['/adubacao-add']);
  }

  public edit(diagnostico: Diagnostico) {
    this.selected = diagnostico;
    this.router.navigate(['/adubacao-edit', this.selected.id]);
  }

  public open(diagnostico: Diagnostico) {
    this.selected = diagnostico;
    this.router.navigate(['/adubacao-detail', this.selected.id]);
  }

  public deleteDialog(adubacao: Diagnostico) {
    const dialogRef = this.dialog.open(AdubacaoDeleteDialogComponent);
    dialogRef.afterClosed().subscribe(result => {
      if (result === 'confirm') {
        this.delete(adubacao);
      }
    });
  }

  private delete(adubacao: Diagnostico) {
    this.isLoading = true;
    this.adubacaoService.delete(adubacao.id)
      .take(1)
      .do(() => {
        this.isLoading = false;
        this.refresh();
      })
      .subscribe((res: boolean) => res);
  }

}
