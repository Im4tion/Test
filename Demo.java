	public List<AcuerdoSuministroVO> getAcuerdosSuministroProveedor(String codigoProveedor, String empresa) {

		List<DatosModificados> cambiosPendientesPedidoCompra = datosModificadosService.buscarCambiosPendientes(Constants.ACUERDOS_SUMINISTRO.PANTALLA, Constants.ACUERDOS_SUMINISTRO.BLOQUE_PEDIDO_COMPRA, codigoProveedor + "**" + empresa);
		List<DatosModificados> cambiosPendientesControlStock = datosModificadosService.buscarCambiosPendientes(Constants.ACUERDOS_SUMINISTRO.PANTALLA, Constants.ACUERDOS_SUMINISTRO.BLOQUE_PEDIDO_COMPRA, codigoProveedor + "**" + empresa);
		List<DatosModificados> cambiosPendientes = new ArrayList<>();
		// cambiosPendientes.addAll(cambiosPendientesDatosArticulo);
		cambiosPendientes.addAll(cambiosPendientesControlStock);
		cambiosPendientes.addAll(cambiosPendientesPedidoCompra);

		// List<AcuerdoSuministro> acuerdosSuministro = acuerdoSuministroRepository
		// .findByAcuerdoSuministroKeyCodigoProveedorAndAcuerdoSuministroKeyDataareaid(codigoProveedor, empresa);

		List<AcuerdoSuministro> acuerdosSuministro = acuerdoSuministroRepository.findAcuerdoSuministrosByProveedorNoCancelado(codigoProveedor, empresa);

		List<AcuerdoSuministroVO> acuerdosSuministroVO = getAcuerdosSuministroVO(acuerdosSuministro, cambiosPendientes);
		return acuerdosSuministroVO;

	}
