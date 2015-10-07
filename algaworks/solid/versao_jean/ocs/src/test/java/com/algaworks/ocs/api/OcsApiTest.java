package com.algaworks.ocs.api;

import com.algaworks.ocs.cdr.CDRFileLocator;
import com.algaworks.ocs.cdr.CDRGeneratorFile;
import com.algaworks.ocs.log.ApiLogger;
import com.algaworks.ocs.repository.Clientes;
import com.algaworks.ocs.service.ClienteService;

public class OcsApiTest {

	public static void main(String[] args) {
		CDRFileLocator cdrFileLocator = new CDRGeneratorFile("/tmp/cdr");
		Clientes clientes = new Clientes();
		
		ClienteService clienteService = new ClienteService(clientes);
		ApiLogger apiLogger = new ApiLogger(clienteService, clienteService);
		OcsApi ocsApi = new OcsApi(cdrFileLocator, clientes, clienteService, apiLogger);
		
		Ligacao ligacao = ocsApi.autorizar("11111111");
		
	}
}
