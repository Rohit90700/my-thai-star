import { Component, OnInit, Inject } from '@angular/core';
import { IPageChangeEvent, ITdDataTableColumn, TdDataTableService } from '@covalent/core';
import { ExtraView, OrderView, BookingView, ReservationView, OrderListView } from '../../../shared/viewModels/interfaces';
import { WaiterCockpitService } from '../../shared/waiter-cockpit.service';
import { MD_DIALOG_DATA } from '@angular/material';
import { config } from '../../../config';

@Component({
  selector: 'cockpit-order-dialog',
  templateUrl: './order-dialog.component.html',
  styleUrls: ['./order-dialog.component.scss'],
})
export class OrderDialogComponent implements OnInit {

  private data: any;

  private datat: BookingView[] = [];
  private columnst: ITdDataTableColumn[] = [
    { name: 'bookingDate', label: 'Reservation date'},
    { name: 'creationDate', label: 'Creation date'},
    { name: 'name', label: 'Owner' },
    { name: 'email', label: 'Email' },
    { name: 'tableId', label: 'Table'},
  ];

  private datao: OrderView[] = [];
  private columnso: ITdDataTableColumn[] = [
    { name: 'dish.name', label: 'Dish'},
    { name: 'orderLine.comment', label: 'Comments'},
    { name: 'extras', label: 'Extra' },
    { name: 'orderLine.amount', label: 'Quantity' },
    { name: 'dish.price', label: 'Price', numeric: true, format: (v: number) => v.toFixed(2)},
  ];

  private pageSizes: number[] = config.pageSizesDialog;

  private fromRow: number = 1;
  private currentPage: number = 1;
  private pageSize: number = 5;
  private filteredData: OrderView[] = this.datao;
  private totalPrice: number;

  constructor(private _dataTableService: TdDataTableService,
              private waiterCockpitService: WaiterCockpitService,
              @Inject(MD_DIALOG_DATA) dialogData: any) {
                this.data = dialogData.row;
  }

  ngOnInit(): void {
    this.totalPrice = this.waiterCockpitService.getTotalPrice(this.data.orderLines);
    this.datao = this.waiterCockpitService.orderComposer(this.data.orderLines);
    this.datat.push(this.data.booking);
    this.filter();
}

  page(pagingEvent: IPageChangeEvent): void {
    this.fromRow = pagingEvent.fromRow;
    this.currentPage = pagingEvent.page;
    this.pageSize = pagingEvent.pageSize;
    this.filter();
  }

  filter(): void {
    let newData: any[] = this.datao;
    newData = this._dataTableService.pageData(newData, this.fromRow, this.currentPage * this.pageSize);
    this.filteredData = newData;
  }
}
