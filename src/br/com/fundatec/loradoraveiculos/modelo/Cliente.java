package br.com.fundatec.loradoraveiculos.modelo;

public class Cliente {
	
	private static Long proximoId = 1L;
	
	private Long id;
	private TipoPessoa tipoPessoa;
	private String nome;
	private Long numeroDocumento;
	private TipoDocumento tipoDocumento;
	private String razaoSocial;
	private Long cnpj;
	private Endereco endereco;
	
	public Cliente (String nome, TipoDocumento tipoDocumento, Long numeroDocumento, Endereco endereco) {
		this.setId(proximoId++);
		this.tipoPessoa = TipoPessoa.PESSOA_FISICA;
		this.nome = nome;
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.endereco = endereco;
	}
	
	public Cliente (String razaoSocial, Long cnpj, Endereco endereco) {
		this.setId(proximoId++);
		this.tipoPessoa = TipoPessoa.PESSOA_JURIDICA;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
} 

