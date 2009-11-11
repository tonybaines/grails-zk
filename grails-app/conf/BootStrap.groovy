class BootStrap {

     def init = { servletContext ->
        1000.times { i ->
            new Book(author: "Name $i", title: "Title $i").save()
        }
     }
     def destroy = {
     }
}