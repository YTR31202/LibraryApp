import { Component } from '@angular/core';
import { Book } from '../book.model';
import { BookServiceService } from '../book-service.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent {
  book:Book={
    bookId: '',
    bookName: ' ',
    noOfPages:' ',
    publicationName:' ',
    authorName:' ',
  };
  submitted = false;
  constructor(private bookservice:BookServiceService){}
  saveBook():void{
    const data={
      bookId: this.book.bookId,
      bookName:this.book.bookName,
      noOfPages:this.book.noOfPages,
      publicationName:this.book.publicationName,
      authorName:this.book.authorName,
    };
    this.bookservice.create(data).subscribe({
      next:(res) =>{
        console.log(res);
        this.submitted=true;
      },
      error:(e)=>console.error(e)
    });
  }
  newBook():void{
    this.submitted=false;
    this.book={
      bookId: '',
      bookName:'',
      noOfPages: '',
      publicationName:'',
      authorName:'',

    };
  }

}
