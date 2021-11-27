package br.com.edu.library.ServiceAndRepository.TesteBiblioteca;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Library;
import br.com.edu.library.dto.impl.LibraryDTO;
import br.com.edu.library.repository.LibraryRepository;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class LibraryMockTest {

    @MockBean
    private LibraryService service;

    @Autowired
    private LibraryRepository repository;


    @Test
    public void testGetLibrary() throws Exception{
        Library biblio1 = new Library();
        biblio1.setName("Fafic1");
        biblio1.setInstitution("FAFIC1");

        Library result1 = biblio1;

        Library biblio2 = new Library();
        biblio2.setName("Fafic2");
        biblio2.setInstitution("FAFIC2");

        Library result2 = biblio2;

        when(service.save(result1)).thenReturn(repository.save(result1));

        assertThat(service.save(result1).getName()).isNotEqualTo(result2.getName());

        verify(service).save(result1);



    }
}
