package com.rentingapp.rentcar.modules.client;

import com.rentingapp.rentcar.modules.client.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientServiceTest {

    private static ClientService clientService;
    private static ClientRepository repository;

    @BeforeAll
    public static void init() {
        repository = Mockito.mock(ClientRepository.class);
        clientService = new ClientService(repository);
    }

    @Test
    void whenAddClientOkThenCorrect() {
        //given
        Client client = new Client();
        client.setFirstName("Ala");
        client.setSurname("MaKota");

        //when
        clientService.addClient(client);

        //then
        Mockito.verify(repository, Mockito.times(1))
               .save(client);
    }

    @Test
    void whenAddClientNotHaveSurnameThenExceptionExpected() {
        //given
        Client client = new Client();
        client.setFirstName("Ala");

        //when
        Assertions.assertThrows(ClientDataError.class, () -> clientService.addClient(client));

    }

    @Test
    void getClients() {
    }

    @Test
    void getClient() {
    }

    @Test
    void deleteClient() {
    }
}