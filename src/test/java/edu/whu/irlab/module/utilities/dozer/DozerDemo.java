package edu.whu.irlab.module.utilities.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapping;
import org.junit.Test;

/**
 * dozer是一种JavaBean的映射工具，类似于apache的BeanUtils。
 * 但是dozer更强大，它可以灵活的处理复杂类型之间的映射。
 * 不但可以进行简单的属性映射、复杂的类型映射、双向映射、递归映射等，
 * 并且可以通过XML配置文件进行灵活的配置。
 * Created by Roger on 2016/5/26.
 */
public class DozerDemo {

    @Test
    public void testDozer(){
        Book book = new Book();
        book.setName("信息检索");
        book.setAuthor("曼宁");

        BookVo vo = new BookVo();

        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.map(book, vo);

        System.out.println(vo.getNamevo()+"\t"+vo.getAuthorvo());
    }

    public class Book {
        private String name;
        private String author;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Book() {
        }
    }

    public class BookVo {
        //一边定义, 双向转换都可以使用
        @Mapping("name")
        private String namevo;
        @Mapping("author")
        private String authorvo;

        public String getNamevo() {
            return namevo;
        }

        public void setNamevo(String namevo) {
            this.namevo = namevo;
        }

        public String getAuthorvo() {
            return authorvo;
        }

        public void setAuthorvo(String authorvo) {
            this.authorvo = authorvo;
        }

        public BookVo() {
        }
    }
}
