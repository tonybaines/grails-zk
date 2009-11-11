import org.zkoss.zkgrails.*
import org.zkoss.zk.ui.event.*

class BookComposer extends GrailsComposer {

    def lstBook
    def pagBook

    def afterCompose = { c ->
        pagBook.totalSize = Book.count()
        redraw()
    }

    def onPaging_pagBook(ForwardEvent fe) {
        def e = fe.origin
        redraw(e.activePage)
    }

    def redraw(page=0) {
        def list = Book.list(offset: page * pagBook.pageSize,
        max: pagBook.pageSize)

        lstBook.clear()
        lstBook.append {
            list.each { e ->
                listitem(value: e) {
                    listcell(label: e.id)
                    listcell(label: e.author)
                    listcell(label: e.title)
                }
            }
        }
    }
}
