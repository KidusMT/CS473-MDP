fun main() {
    val book = Book("Lord of the Rings", "Kyle", 23.0)
    val audioBook = EBook("LOR-PDF", "LOR-EPUB", "LOR-kindle", "LOR", "Kayla", 40.0)
    book.read()
    audioBook.read()
}

open class Book(val title: String,
                val author: String,
                val price: Double){
    open fun read(){
        println("Reading Paper book: $title")
    }
}

class EBook(val pdf: String,
            val epub: String,
            val kindle: String, title: String, author: String, price: Double): Book(title, author, price){
    override fun read(){
        println("Read from Electronic Device $pdf")
    }
}