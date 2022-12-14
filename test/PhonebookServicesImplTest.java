package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookServicesImplTest {
private PhonebookServices phonebookServices;
    @BeforeEach
    void setUp() {
        phonebookServices = new PhonebookServicesImpl();
    }

    @Test
    void PhonebookServicesTest() {
        phonebookServices.register("Amirah","1234");
        assertEquals(1,phonebookServices.countNumberOfUsers());
    }

    @Test
    void registerDuplicatedUserFailsTest(){
        phonebookServices.register("Amirah","08123456789");
        assertThrows(IllegalArgumentException.class, () -> phonebookServices.register("Seun",
                "08123456789"));
    }

}