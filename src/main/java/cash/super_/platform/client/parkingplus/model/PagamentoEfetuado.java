/*
 * API de pagamento mobile WPS Brasil
 * <#noparse> ### Objetivo  Este documento tem por objetivo definir a interface de integração entre o sistema Parking Plus Enterprise e Aplicativos para Smartphones. A integração possibilitará o pagamento da estadia dos clientes do estacionamento através desse aplicativo.  ### Integração A integração entre as aplicações será realizada por meio de webservice disponibilizados em ambiente de internet. Esse webservice possibilitará a consulta do valor da estadia dos tickets e o pagamento do ticket do estacionamento utilizando como meio de pagamento o cartão de crédito.  O sistema Parking Plus Enterprise encaminha os dados do cliente para os sistemas Gateway de Pagamento de forma que estes possam solicitar a autorização da cobrança em cartão de crédito, da estadia do estacionamento.  ### Especificação dos Serviços (Webservices) O protocolo de comunicação utilizado para a integração entre o sistema Parking Plus Enterprise e o Aplicativo será o HTTPS. O webservice utilizará a tecnologia REST para o acesso aos serviços, e JSON para o POST e o retorno das informações solicitadas para o webservice. Dessa forma, o aplicativo desenvolvido deverá atender aos requisitos necessários para acessar esses serviços.    ## Mapa de Erros |errorCode |descrição |mensagem padrão | | --- | --- | --- | | 0 | Nenhum erro. |   | | 999 |Utilizado quando alguma exceção não especifica é lançada.| Erro no processamento da solicitação. | |1 | O ticket não foi encontrado no banco do Enterprise. | Ticket não encontrado. | | 2 | Garagem offline no enterprise. | Serviço indisponível no momento. | | 3 | O número do ticket possui CRC inválido. | O número do ticket digitado não é um número de ticket válido. | | 4 |O ticket não foi encontrado no pátio. Ocorre se o ticket já saiu do pátio. Pode ocorrer se um ticket correto(ainda no pátio) não foi sincronizado e um ticket de outra garagem é encontrado mas o mesmo já saiu. | Ticket inválido ou já processado. | | 5* | A garagem não possui uma Loja Virtual Cadastrada. | A Garagem não possui uma Loja Virtual Cadastrada. | | 6 | A garagem não se encontra na whitelist de garagens permitidas da API. | Não é permitida a validação de tickets desta garagem. | | 7 | O ticket já recebeu uma validação hoje. | Você já ganhou seu estacionamento gratuito hoje. | | 8 | O valor do pagamento é inválido. Valor a pagar é maior que o sendo pago. | Valor Inválido. | | 9 | Transação já realizada. idTransacao já existe no banco. | Transação já realizada. | | 10* | A apikey enviada é inválida. | Aplicativo não autorizado! | | 11** | ~~O cartão possui CRC inválido.~~ | ~~O número do Cartão Pré-Pago é inválido.~~ | | 12** | ~~O cartão não foi encontrado no banco.~~ | ~~Cartão Pré-Pago não encontrado.~~ | | 13 | Erro ao descriptografar o cartão de crédito. | Cartão com problema, tente recadastrar. | | 14 | Erro ao tentar se conectar com o gateway de pagamento. | Erro de conexão com o Gateway! | | 15 | Existe alguma restrição para o cartão. | Serviço não autorizado para este cartão! | | 16 | Erro de transação com o gateway. | Sua transação não foi concluída. Aguarde alguns instantes e tente novamente. | | 17 | Emissora do cartão indisponível para o gateway. | Emissor indisponível! Aguarde alguns instantes e tente novamente ou entre em contato com a emissora de seu cartão. | | 18* | Existe algum erro na configuração do gateway. | Pagamento indisponível no momento. | | 19 | Informações do cartão inválidas. | Cartão inválido! Entre em contato com a emissora do seu cartão para mais detalhes. | | 20 | A transação foi negada pelo emissor do cartão. | Transação negada pelo emissor! Entre em contato com a emissora do seu cartão para mais detalhes. | | 21 | Pagamento desabilitado. | O pagamento está momentaneamente desabilitado. | | 22 | Erro ao tentar criptografar o cartão de crédito. | Erro ao criptografar cartão! | | 23 | Erro ao tentar encontrar o cliente no banco de dados. Pode ocorrer se o UDID do cliente for alterado mas o cartão criptografado antigo for utilizado. | Cliente alterado! recadastre o cartão. | | 24 | Erro ao descriptografar um cartão de crédito. | Cartão de crédito com problema, tente recadastrar. | | 25** | ~~O Método chamado foi descontinuado.~~ | ~~Este método foi descontinuado.~~ | | 26 | Id/Chave de garagem não encontrada no sistema | Falha ao encontrar garagem! |    \\* Deve ser corrigido durante a homologação  ** Apenas retornados por métodos internos ou ainda não documentados  </#noparse>
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package cash.super_.platform.client.parkingplus.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PagamentoEfetuado
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-10T17:02:09.002Z")



public class PagamentoEfetuado {
  @JsonProperty("cnpjGaragem")
  private String cnpjGaragem = null;

  @JsonProperty("codigoAutorizacao")
  private String codigoAutorizacao = null;

  @JsonProperty("cpfCnpj")
  private String cpfCnpj = null;

  @JsonProperty("data")
  private Long data = null;

  @JsonProperty("estaticonamento")
  private String estaticonamento = null;

  @JsonProperty("linkLogoGaragem")
  private String linkLogoGaragem = null;

  @JsonProperty("nfseCodigoVerificacao")
  private String nfseCodigoVerificacao = null;

  @JsonProperty("nfseNumero")
  private String nfseNumero = null;

  @JsonProperty("nfseQrCode")
  private String nfseQrCode = null;

  @JsonProperty("nsu")
  private String nsu = null;

  @JsonProperty("permanencia")
  private Long permanencia = null;

  @JsonProperty("permanenciaFim")
  private Long permanenciaFim = null;

  @JsonProperty("prepago")
  private Boolean prepago = null;

  @JsonProperty("rps")
  private String rps = null;

  @JsonProperty("serieRps")
  private String serieRps = null;

  @JsonProperty("ticket")
  private String ticket = null;

  /**
   * O tipo do serviço pago.
   */
  public enum TipoEnum {
    CARGA_CREDITO("CARGA_CREDITO"),
    
    CARTAO_DEBITO("CARTAO_DEBITO"),
    
    TICKET("TICKET");

    private String value;

    TipoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoEnum fromValue(String text) {
      for (TipoEnum b : TipoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipo")
  private TipoEnum tipo = null;

  @JsonProperty("valorPago")
  private Long valorPago = null;

  @JsonProperty("valorDesconto")
  private Integer valorDesconto = null;

  public PagamentoEfetuado cnpjGaragem(String cnpjGaragem) {
    this.cnpjGaragem = cnpjGaragem;
    return this;
  }

   /**
   * CNPJ da Garagem
   * @return cnpjGaragem
  **/
  @ApiModelProperty(required = true, value = "CNPJ da Garagem")
  public String getCnpjGaragem() {
    return cnpjGaragem;
  }

  public void setCnpjGaragem(String cnpjGaragem) {
    this.cnpjGaragem = cnpjGaragem;
  }

  public PagamentoEfetuado codigoAutorizacao(String codigoAutorizacao) {
    this.codigoAutorizacao = codigoAutorizacao;
    return this;
  }

   /**
   * O Código de Autorização da nota fiscal.
   * @return codigoAutorizacao
  **/
  @ApiModelProperty(value = "O Código de Autorização da nota fiscal.")
  public String getCodigoAutorizacao() {
    return codigoAutorizacao;
  }

  public void setCodigoAutorizacao(String codigoAutorizacao) {
    this.codigoAutorizacao = codigoAutorizacao;
  }

  public PagamentoEfetuado cpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
    return this;
  }

   /**
   * CPF enviado para geração de RPS no pagamento
   * @return cpfCnpj
  **/
  @ApiModelProperty(value = "CPF enviado para geração de RPS no pagamento")
  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public PagamentoEfetuado data(Long data) {
    this.data = data;
    return this;
  }

   /**
   * Data do servidor na hora do pagamento(Unix Epoch em milissegundos)
   * @return data
  **/
  @ApiModelProperty(required = true, value = "Data do servidor na hora do pagamento(Unix Epoch em milissegundos)")
  public Long getData() {
    return data;
  }

  public void setData(Long data) {
    this.data = data;
  }

  public PagamentoEfetuado estaticonamento(String estaticonamento) {
    this.estaticonamento = estaticonamento;
    return this;
  }

   /**
   * Nome da Garagem associada ao ticket
   * @return estaticonamento
  **/
  @ApiModelProperty(required = true, value = "Nome da Garagem associada ao ticket")
  public String getEstaticonamento() {
    return estaticonamento;
  }

  public void setEstaticonamento(String estaticonamento) {
    this.estaticonamento = estaticonamento;
  }

  public PagamentoEfetuado linkLogoGaragem(String linkLogoGaragem) {
    this.linkLogoGaragem = linkLogoGaragem;
    return this;
  }

   /**
   * Link de uma imagem para o estacionamento
   * @return linkLogoGaragem
  **/
  @ApiModelProperty(value = "Link de uma imagem para o estacionamento")
  public String getLinkLogoGaragem() {
    return linkLogoGaragem;
  }

  public void setLinkLogoGaragem(String linkLogoGaragem) {
    this.linkLogoGaragem = linkLogoGaragem;
  }

  public PagamentoEfetuado nfseCodigoVerificacao(String nfseCodigoVerificacao) {
    this.nfseCodigoVerificacao = nfseCodigoVerificacao;
    return this;
  }

   /**
   * O código de verificação da nota fiscal.
   * @return nfseCodigoVerificacao
  **/
  @ApiModelProperty(value = "O código de verificação da nota fiscal.")
  public String getNfseCodigoVerificacao() {
    return nfseCodigoVerificacao;
  }

  public void setNfseCodigoVerificacao(String nfseCodigoVerificacao) {
    this.nfseCodigoVerificacao = nfseCodigoVerificacao;
  }

  public PagamentoEfetuado nfseNumero(String nfseNumero) {
    this.nfseNumero = nfseNumero;
    return this;
  }

   /**
   * O número da nota fiscal.
   * @return nfseNumero
  **/
  @ApiModelProperty(value = "O número da nota fiscal.")
  public String getNfseNumero() {
    return nfseNumero;
  }

  public void setNfseNumero(String nfseNumero) {
    this.nfseNumero = nfseNumero;
  }

  public PagamentoEfetuado nfseQrCode(String nfseQrCode) {
    this.nfseQrCode = nfseQrCode;
    return this;
  }

   /**
   * O qrcode da nota fiscal. (Quando o nfseCodigoVerificacao estiver vazio este qrcode é da nota em contingência)
   * @return nfseQrCode
  **/
  @ApiModelProperty(value = "O qrcode da nota fiscal. (Quando o nfseCodigoVerificacao estiver vazio este qrcode é da nota em contingência)")
  public String getNfseQrCode() {
    return nfseQrCode;
  }

  public void setNfseQrCode(String nfseQrCode) {
    this.nfseQrCode = nfseQrCode;
  }

  public PagamentoEfetuado nsu(String nsu) {
    this.nsu = nsu;
    return this;
  }

   /**
   * O Número Sequencial Único da nota fiscal.
   * @return nsu
  **/
  @ApiModelProperty(value = "O Número Sequencial Único da nota fiscal.")
  public String getNsu() {
    return nsu;
  }

  public void setNsu(String nsu) {
    this.nsu = nsu;
  }

  public PagamentoEfetuado permanencia(Long permanencia) {
    this.permanencia = permanencia;
    return this;
  }

   /**
   * Data de entrada(Unix Epoch em milissegundos)
   * @return permanencia
  **/
  @ApiModelProperty(value = "Data de entrada(Unix Epoch em milissegundos)")
  public Long getPermanencia() {
    return permanencia;
  }

  public void setPermanencia(Long permanencia) {
    this.permanencia = permanencia;
  }

  public PagamentoEfetuado permanenciaFim(Long permanenciaFim) {
    this.permanenciaFim = permanenciaFim;
    return this;
  }

   /**
   * Uma previsão da data permitida para saída se o ticket for pago com o valor atual (Unix Epoch em milissegundos)
   * @return permanenciaFim
  **/
  @ApiModelProperty(value = "Uma previsão da data permitida para saída se o ticket for pago com o valor atual (Unix Epoch em milissegundos)")
  public Long getPermanenciaFim() {
    return permanenciaFim;
  }

  public void setPermanenciaFim(Long permanenciaFim) {
    this.permanenciaFim = permanenciaFim;
  }

  public PagamentoEfetuado prepago(Boolean prepago) {
    this.prepago = prepago;
    return this;
  }

   /**
   * Se o pagamento foi prepago
   * @return prepago
  **/
  @ApiModelProperty(value = "Se o pagamento foi prepago")
  public Boolean isPrepago() {
    return prepago;
  }

  public void setPrepago(Boolean prepago) {
    this.prepago = prepago;
  }

  public PagamentoEfetuado rps(String rps) {
    this.rps = rps;
    return this;
  }

   /**
   * O número do RPS gerado
   * @return rps
  **/
  @ApiModelProperty(value = "O número do RPS gerado")
  public String getRps() {
    return rps;
  }

  public void setRps(String rps) {
    this.rps = rps;
  }

  public PagamentoEfetuado serieRps(String serieRps) {
    this.serieRps = serieRps;
    return this;
  }

   /**
   * A série do RPS
   * @return serieRps
  **/
  @ApiModelProperty(value = "A série do RPS")
  public String getSerieRps() {
    return serieRps;
  }

  public void setSerieRps(String serieRps) {
    this.serieRps = serieRps;
  }

  public PagamentoEfetuado ticket(String ticket) {
    this.ticket = ticket;
    return this;
  }

   /**
   * O número do ticket
   * @return ticket
  **/
  @ApiModelProperty(value = "O número do ticket")
  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public PagamentoEfetuado tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

   /**
   * O tipo do serviço pago.
   * @return tipo
  **/
  @ApiModelProperty(value = "O tipo do serviço pago.")
  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }

  public PagamentoEfetuado valorPago(Long valorPago) {
    this.valorPago = valorPago;
    return this;
  }

   /**
   * Valor do pagamento
   * @return valorPago
  **/
  @ApiModelProperty(required = true, value = "Valor do pagamento")
  public Long getValorPago() {
    return valorPago;
  }

  public void setValorPago(Long valorPago) {
    this.valorPago = valorPago;
  }

  public PagamentoEfetuado valorDesconto(Integer valorDesconto) {
    this.valorDesconto = valorDesconto;
    return this;
  }

   /**
   * Valor do desconto aplicado na tarifa em centavos(R$1,50 &#x3D; 150)
   * @return valorDesconto
  **/
  @ApiModelProperty(value = "Valor do desconto aplicado na tarifa em centavos(R$1,50 = 150)")
  public Integer getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(Integer valorDesconto) {
    this.valorDesconto = valorDesconto;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PagamentoEfetuado pagamentoEfetuado = (PagamentoEfetuado) o;
    return Objects.equals(this.cnpjGaragem, pagamentoEfetuado.cnpjGaragem) &&
        Objects.equals(this.codigoAutorizacao, pagamentoEfetuado.codigoAutorizacao) &&
        Objects.equals(this.cpfCnpj, pagamentoEfetuado.cpfCnpj) &&
        Objects.equals(this.data, pagamentoEfetuado.data) &&
        Objects.equals(this.estaticonamento, pagamentoEfetuado.estaticonamento) &&
        Objects.equals(this.linkLogoGaragem, pagamentoEfetuado.linkLogoGaragem) &&
        Objects.equals(this.nfseCodigoVerificacao, pagamentoEfetuado.nfseCodigoVerificacao) &&
        Objects.equals(this.nfseNumero, pagamentoEfetuado.nfseNumero) &&
        Objects.equals(this.nfseQrCode, pagamentoEfetuado.nfseQrCode) &&
        Objects.equals(this.nsu, pagamentoEfetuado.nsu) &&
        Objects.equals(this.permanencia, pagamentoEfetuado.permanencia) &&
        Objects.equals(this.permanenciaFim, pagamentoEfetuado.permanenciaFim) &&
        Objects.equals(this.prepago, pagamentoEfetuado.prepago) &&
        Objects.equals(this.rps, pagamentoEfetuado.rps) &&
        Objects.equals(this.serieRps, pagamentoEfetuado.serieRps) &&
        Objects.equals(this.ticket, pagamentoEfetuado.ticket) &&
        Objects.equals(this.tipo, pagamentoEfetuado.tipo) &&
        Objects.equals(this.valorPago, pagamentoEfetuado.valorPago) &&
        Objects.equals(this.valorDesconto, pagamentoEfetuado.valorDesconto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cnpjGaragem, codigoAutorizacao, cpfCnpj, data, estaticonamento, linkLogoGaragem, nfseCodigoVerificacao, nfseNumero, nfseQrCode, nsu, permanencia, permanenciaFim, prepago, rps, serieRps, ticket, tipo, valorPago, valorDesconto);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PagamentoEfetuado {\n");
    
    sb.append("    cnpjGaragem: ").append(toIndentedString(cnpjGaragem)).append("\n");
    sb.append("    codigoAutorizacao: ").append(toIndentedString(codigoAutorizacao)).append("\n");
    sb.append("    cpfCnpj: ").append(toIndentedString(cpfCnpj)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    estaticonamento: ").append(toIndentedString(estaticonamento)).append("\n");
    sb.append("    linkLogoGaragem: ").append(toIndentedString(linkLogoGaragem)).append("\n");
    sb.append("    nfseCodigoVerificacao: ").append(toIndentedString(nfseCodigoVerificacao)).append("\n");
    sb.append("    nfseNumero: ").append(toIndentedString(nfseNumero)).append("\n");
    sb.append("    nfseQrCode: ").append(toIndentedString(nfseQrCode)).append("\n");
    sb.append("    nsu: ").append(toIndentedString(nsu)).append("\n");
    sb.append("    permanencia: ").append(toIndentedString(permanencia)).append("\n");
    sb.append("    permanenciaFim: ").append(toIndentedString(permanenciaFim)).append("\n");
    sb.append("    prepago: ").append(toIndentedString(prepago)).append("\n");
    sb.append("    rps: ").append(toIndentedString(rps)).append("\n");
    sb.append("    serieRps: ").append(toIndentedString(serieRps)).append("\n");
    sb.append("    ticket: ").append(toIndentedString(ticket)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    valorPago: ").append(toIndentedString(valorPago)).append("\n");
    sb.append("    valorDesconto: ").append(toIndentedString(valorDesconto)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

