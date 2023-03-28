import { Component,Input,OnInit } from '@angular/core';
import { BookServiceService } from '../book-service.service';
import { Book } from '../book.model';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-bookdetails',
  templateUrl: './bookdetails.component.html',
  styleUrls: ['./bookdetails.component.css']
})
export class BookdetailsComponent implements OnInit {
  @Input() viewMode=false;
  @Input() tempbook:Book={
    bookId:"",
    bookName:"",
    noOfPages:"",
    publicationName:"",
    authorName:""
  };
  message= '';

  constructor(
    private tempbookservice:BookServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getbook(this.route.snapshot.params["id"]);
    }
  }

  getbook(id: string): void {
    this.tempbookservice.get(id)
      .subscribe({
        next: (data) => {
          this.tempbook = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  

  updateBook(): void {
    this.message = '';

    this.tempbookservice.update(this.tempbook.bookId, this.tempbook)
      .subscribe({
        next: (res) => {
          console.log(res);
          //this.message = res.message ? res.message : 'This tutorial was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteBook(): void {
    this.tempbookservice.delete(this.tempbook.bookId)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/books']);
        },
        error: (e) => console.error(e)
      });
  }


}
