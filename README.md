**Add book**
mutation MyMutation {
  addBook(bookInput: {
    id: 3,
    title: "Harry Potter and the Philosopher's Stone",
    pages: 223,
    author: {
      name: "J.K. Rowling"
    }
  }) {
    id
    title
    pages
    author {
      name
    }
  }
}

**Update book**
mutation MyMutation{
 updateBook(id: 2, title: "Spring in Action"){
  id
  title
  pages
  author{
    name
  }
}
}

**Get All Books**
query MyQuery{
  allBooks{
      id
    title
    pages
    author {
      name
    }
  }
}

**Get Book by ID**
query MyQuery{
  bookById(id: 2){
      id
    title
    pages
    author {
      name
    }
  }
}
