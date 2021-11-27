package br.com.edu.library.ServiceAndRepository.TesteLivro;

import br.com.edu.library.domain.Book;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.repository.BookRepository;
import br.com.edu.library.service.impl.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LivroMockTest {

    @Autowired
    private BookService service;

    @MockBean
    private BookRepository repository;


    @Test
    public void testCreateLivroMock() {
        Book livro1 = new Book();
        livro1.setName("Livro1");
        livro1.setIsbn("2b");
        livro1.setField(BookField.EXACT);


        Book livro2 = new Book();
        livro2.setName("Livro2");
        livro2.setIsbn("3b");
        livro2.setField(BookField.EXACT);

        when(repository.save(livro1)).thenReturn(livro1);
        assertThat(service.save(livro1)).isNotEqualTo(livro2);



    }
    @Test
    public void testDeleteLivroMock() {
        Book livro1 = new Book();

        when(repository.save(livro1)).thenReturn(livro1);
        livro1.setId(UUID.fromString("21b89928-e0b1-4b5c-81a8-4fded9d31df1"));

        assertThat(service.deleteById(UUID.fromString("21b89928-e0b1-4b5c-81a8-4fded9d31df1")))
                .isTrue();
    }

}
