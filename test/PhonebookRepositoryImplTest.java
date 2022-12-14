package data.repositories;

import data.models.Phonebook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookRepositoryImplTest {

    private PhonebookRepository phonebookRepository;
    @BeforeEach
    void setUp() {
         phonebookRepository = new PhonebookRepositoryImpl();
    }
    @Test
        public void savePhonebookTotalPhonebookIsOneTest() {
        //given I have a new phonebook repository
        //when I try to save a contact
        //assert equals count is 1

        Phonebook amirah = new Phonebook();
        phonebookRepository.save(amirah);
        assertEquals(1, phonebookRepository.count());
    }

    @Test
    public void savePhonebookFindByIdReturnSavedPhoneBook() {
        //given I have a new phonebook repository
        //when I try to save a new phonebook
        //and when I find by id
        //assert that phonebook is equals to saved phonebook
        Phonebook amirahPhonebook = new Phonebook();
        amirahPhonebook.setOwnersPhoneNumber("9098");
        amirahPhonebook.setOwnersName("Amirah");
        phonebookRepository.save(amirahPhonebook);
        Phonebook savedPhonebook = phonebookRepository.findById("9098");
        assertEquals(amirahPhonebook, savedPhonebook);
        assertEquals("Amirah", savedPhonebook.getOwnersName());
    }

    @Test
    public void updatePhonebookFindByIdReturnUpdatedPhoneBook() {
        //given I have a new phonebook repository
        //I save a new phonebook
        //when I update
        //assert that phonebook details has been updated
        Phonebook amirahPhonebook = new Phonebook();
        amirahPhonebook.setOwnersPhoneNumber("9098");
        amirahPhonebook.setOwnersName("Amirah");
        phonebookRepository.save(amirahPhonebook);
        Phonebook updatePhonebook = new Phonebook();
        updatePhonebook.setOwnersName("Adewunmi");
        updatePhonebook.setOwnersPhoneNumber("9098");
        phonebookRepository.save(updatePhonebook);
        Phonebook savedPhonebook = phonebookRepository.findById("9098");
        assertEquals(1, phonebookRepository.count());
        assertEquals("Adewunmi", savedPhonebook.getOwnersName());
    }
}