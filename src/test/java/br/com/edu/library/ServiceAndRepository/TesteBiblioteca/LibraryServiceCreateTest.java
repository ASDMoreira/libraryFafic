package br.com.edu.library.ServiceAndRepository.TesteBiblioteca;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Library;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class LibraryServiceCreateTest {

 //sem mock

    @Autowired
    private LibraryService libraryService;

    @Test
    public void testCreateLibrary1() throws Exception{
        Library livraria1 = new Library();

        livraria1.setName("BiFafic");
        livraria1.setInstitution("Fafics");

        Library livraria2 = new Library();
        livraria2.setName("BiFafic");
        livraria2.setInstitution("Fafics2");

        Library resultado1 = libraryService.save(livraria1);
        Library resultado2 = libraryService.save(livraria2);

        assertThat(resultado1.getName()).isEqualTo(resultado2.getName());
    }

    @Test
    public void testCreateLibrary2() throws Exception{
        Library livraria1 = new Library();

        livraria1.setName("BiFafic1");
        livraria1.setInstitution("Fafics");

        Library livraria2 = new Library();
        livraria2.setName("BiFafic2");
        livraria2.setInstitution("Fafics2");

        Library resultado1 = libraryService.save(livraria1);
        Library resultado2 = libraryService.save(livraria2);

        assertThat(resultado1.getName()).isNotEqualTo(resultado2.getName());


    }
}
