import { Component,OnInit } from '@angular/core';
import { Book } from '../book.model';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {
  book?:Book[];
  index=-1;
  tempbook : Book={};
  Name='';
  constructor(private bookservice:BookServiceService) {}
  ngOnInit(): void {
      this.retrieveBooks();
  }
  retrieveBooks(): void{
    this.bookservice.getAll().subscribe({
      next:(data) =>{
        this.book = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    })
  }
  Refresh(): void {
    this.retrieveBooks();
    this.tempbook = {};
    this.index = -1;
  }

  setBook(book: Book, index: number): void {
    this.tempbook = book;
    this.index = index;
  }

  // removeAllTutorials(): void {
  //   this.bookservice.deleteAll()
  //     .subscribe({
  //       next: (res) => {
  //         console.log(res);
  //         this.refreshList();
  //       },
  //       error: (e) => console.error(e)
  //     });
  // }

  searchName(): void {
    this.tempbook = {};
    this.index = -1;

    this.bookservice.findname(this.Name)
      .subscribe({
        next: (data) => {
          this.book = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
}