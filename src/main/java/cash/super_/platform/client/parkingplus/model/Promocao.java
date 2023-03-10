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
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Promocao
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-10T22:06:45.404Z")



public class Promocao {
  /**
   * Bandeira caso o tipoPromoção seja BANDEIRA
   */
  public enum BandeiraEnum {
    ELO("ELO"),
    
    AURA("AURA"),
    
    AMEX("AMEX"),
    
    VISA("VISA"),
    
    MASTERCARD("MASTERCARD"),
    
    DISCOVER("DISCOVER"),
    
    HIPERCARD("HIPERCARD"),
    
    DINERS("DINERS"),
    
    JCB("JCB");

    private String value;

    BandeiraEnum(String value) {
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
    public static BandeiraEnum fromValue(String text) {
      for (BandeiraEnum b : BandeiraEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("bandeira")
  private BandeiraEnum bandeira = null;

  @JsonProperty("descricao")
  private String descricao = null;

  /**
   * Gets or Sets diasSemana
   */
  public enum DiasSemanaEnum {
    DOMINGO("DOMINGO"),
    
    SEGUNDA("SEGUNDA"),
    
    TERCA("TERCA"),
    
    QUARTA("QUARTA"),
    
    QUINTA("QUINTA"),
    
    SEXTA("SEXTA"),
    
    SABADO("SABADO");

    private String value;

    DiasSemanaEnum(String value) {
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
    public static DiasSemanaEnum fromValue(String text) {
      for (DiasSemanaEnum b : DiasSemanaEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("diasSemana")
  private List<DiasSemanaEnum> diasSemana = null;

  @JsonProperty("exigeAutenticacao")
  private Boolean exigeAutenticacao = null;

  @JsonProperty("horarioFim")
  private DateTime horarioFim = null;

  @JsonProperty("horarioInicio")
  private DateTime horarioInicio = null;

  @JsonProperty("imagem")
  private String imagem = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("quantidadeDisponivel")
  private Integer quantidadeDisponivel = null;

  @JsonProperty("regulamento")
  private String regulamento = null;

  @JsonProperty("systemId")
  private Long systemId = null;

  /**
   * O tipo do desconto
   */
  public enum TipoDescontoEnum {
    PORCENTAGEM("PORCENTAGEM"),
    
    VALOR("VALOR"),
    
    PERMANENCIA("PERMANENCIA"),
    
    PERMANENCIA_FINAL("PERMANENCIA_FINAL"),
    
    MUDANCA_TARIFA("MUDANCA_TARIFA");

    private String value;

    TipoDescontoEnum(String value) {
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
    public static TipoDescontoEnum fromValue(String text) {
      for (TipoDescontoEnum b : TipoDescontoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipoDesconto")
  private TipoDescontoEnum tipoDesconto = null;

  /**
   * O tipo da promoção
   */
  public enum TipoPromocaoEnum {
    BANDEIRA("BANDEIRA"),
    
    CUPOM("CUPOM");

    private String value;

    TipoPromocaoEnum(String value) {
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
    public static TipoPromocaoEnum fromValue(String text) {
      for (TipoPromocaoEnum b : TipoPromocaoEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tipoPromocao")
  private TipoPromocaoEnum tipoPromocao = null;

  @JsonProperty("titulo")
  private String titulo = null;

  @JsonProperty("validade")
  private DateTime validade = null;

  @JsonProperty("valorAlvo")
  private Integer valorAlvo = null;

  @JsonProperty("valorDesconto")
  private Integer valorDesconto = null;

  public Promocao bandeira(BandeiraEnum bandeira) {
    this.bandeira = bandeira;
    return this;
  }

   /**
   * Bandeira caso o tipoPromoção seja BANDEIRA
   * @return bandeira
  **/
  @ApiModelProperty(value = "Bandeira caso o tipoPromoção seja BANDEIRA")
  public BandeiraEnum getBandeira() {
    return bandeira;
  }

  public void setBandeira(BandeiraEnum bandeira) {
    this.bandeira = bandeira;
  }

  public Promocao descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

   /**
   * A descrição da promoção
   * @return descricao
  **/
  @ApiModelProperty(required = true, value = "A descrição da promoção")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Promocao diasSemana(List<DiasSemanaEnum> diasSemana) {
    this.diasSemana = diasSemana;
    return this;
  }

  public Promocao addDiasSemanaItem(DiasSemanaEnum diasSemanaItem) {
    if (this.diasSemana == null) {
      this.diasSemana = new ArrayList<DiasSemanaEnum>();
    }
    this.diasSemana.add(diasSemanaItem);
    return this;
  }

   /**
   * Get diasSemana
   * @return diasSemana
  **/
  @ApiModelProperty(value = "")
  public List<DiasSemanaEnum> getDiasSemana() {
    return diasSemana;
  }

  public void setDiasSemana(List<DiasSemanaEnum> diasSemana) {
    this.diasSemana = diasSemana;
  }

  public Promocao exigeAutenticacao(Boolean exigeAutenticacao) {
    this.exigeAutenticacao = exigeAutenticacao;
    return this;
  }

   /**
   * Se a promoção exige autenticação
   * @return exigeAutenticacao
  **/
  @ApiModelProperty(example = "false", required = true, value = "Se a promoção exige autenticação")
  public Boolean isExigeAutenticacao() {
    return exigeAutenticacao;
  }

  public void setExigeAutenticacao(Boolean exigeAutenticacao) {
    this.exigeAutenticacao = exigeAutenticacao;
  }

  public Promocao horarioFim(DateTime horarioFim) {
    this.horarioFim = horarioFim;
    return this;
  }

   /**
   * Horário em que a promoção pode ser utilizada (fim)
   * @return horarioFim
  **/
  @ApiModelProperty(required = true, value = "Horário em que a promoção pode ser utilizada (fim)")
  public DateTime getHorarioFim() {
    return horarioFim;
  }

  public void setHorarioFim(DateTime horarioFim) {
    this.horarioFim = horarioFim;
  }

  public Promocao horarioInicio(DateTime horarioInicio) {
    this.horarioInicio = horarioInicio;
    return this;
  }

   /**
   * Horário em que a promoção pode ser utilizada (inicio)
   * @return horarioInicio
  **/
  @ApiModelProperty(required = true, value = "Horário em que a promoção pode ser utilizada (inicio)")
  public DateTime getHorarioInicio() {
    return horarioInicio;
  }

  public void setHorarioInicio(DateTime horarioInicio) {
    this.horarioInicio = horarioInicio;
  }

  public Promocao imagem(String imagem) {
    this.imagem = imagem;
    return this;
  }

   /**
   * Url para uma imagem para a promoção
   * @return imagem
  **/
  @ApiModelProperty(required = true, value = "Url para uma imagem para a promoção")
  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public Promocao nome(String nome) {
    this.nome = nome;
    return this;
  }

   /**
   * O nome da promoção (até 15 caracteres)
   * @return nome
  **/
  @ApiModelProperty(required = true, value = "O nome da promoção (até 15 caracteres)")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Promocao quantidadeDisponivel(Integer quantidadeDisponivel) {
    this.quantidadeDisponivel = quantidadeDisponivel;
    return this;
  }

   /**
   * Quantidade disponível desta promoção
   * @return quantidadeDisponivel
  **/
  @ApiModelProperty(required = true, value = "Quantidade disponível desta promoção")
  public Integer getQuantidadeDisponivel() {
    return quantidadeDisponivel;
  }

  public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
    this.quantidadeDisponivel = quantidadeDisponivel;
  }

  public Promocao regulamento(String regulamento) {
    this.regulamento = regulamento;
    return this;
  }

   /**
   * A regulamentação da promoção
   * @return regulamento
  **/
  @ApiModelProperty(required = true, value = "A regulamentação da promoção")
  public String getRegulamento() {
    return regulamento;
  }

  public void setRegulamento(String regulamento) {
    this.regulamento = regulamento;
  }

  public Promocao systemId(Long systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * O id da promoção
   * @return systemId
  **/
  @ApiModelProperty(required = true, value = "O id da promoção")
  public Long getSystemId() {
    return systemId;
  }

  public void setSystemId(Long systemId) {
    this.systemId = systemId;
  }

  public Promocao tipoDesconto(TipoDescontoEnum tipoDesconto) {
    this.tipoDesconto = tipoDesconto;
    return this;
  }

   /**
   * O tipo do desconto
   * @return tipoDesconto
  **/
  @ApiModelProperty(required = true, value = "O tipo do desconto")
  public TipoDescontoEnum getTipoDesconto() {
    return tipoDesconto;
  }

  public void setTipoDesconto(TipoDescontoEnum tipoDesconto) {
    this.tipoDesconto = tipoDesconto;
  }

  public Promocao tipoPromocao(TipoPromocaoEnum tipoPromocao) {
    this.tipoPromocao = tipoPromocao;
    return this;
  }

   /**
   * O tipo da promoção
   * @return tipoPromocao
  **/
  @ApiModelProperty(required = true, value = "O tipo da promoção")
  public TipoPromocaoEnum getTipoPromocao() {
    return tipoPromocao;
  }

  public void setTipoPromocao(TipoPromocaoEnum tipoPromocao) {
    this.tipoPromocao = tipoPromocao;
  }

  public Promocao titulo(String titulo) {
    this.titulo = titulo;
    return this;
  }

   /**
   * Titulo da promoção
   * @return titulo
  **/
  @ApiModelProperty(required = true, value = "Titulo da promoção")
  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Promocao validade(DateTime validade) {
    this.validade = validade;
    return this;
  }

   /**
   * A data de validade da promoção
   * @return validade
  **/
  @ApiModelProperty(required = true, value = "A data de validade da promoção")
  public DateTime getValidade() {
    return validade;
  }

  public void setValidade(DateTime validade) {
    this.validade = validade;
  }

  public Promocao valorAlvo(Integer valorAlvo) {
    this.valorAlvo = valorAlvo;
    return this;
  }

   /**
   * Valor necessário para atingir a promoção
   * @return valorAlvo
  **/
  @ApiModelProperty(required = true, value = "Valor necessário para atingir a promoção")
  public Integer getValorAlvo() {
    return valorAlvo;
  }

  public void setValorAlvo(Integer valorAlvo) {
    this.valorAlvo = valorAlvo;
  }

  public Promocao valorDesconto(Integer valorDesconto) {
    this.valorDesconto = valorDesconto;
    return this;
  }

   /**
   * Caso tipoDesconto; VALOR: valor do desconto; PORCENTAGEM: porcentagem de desconto; PERMANENCIA: tempo em minutos; MUDANCA_TARIFA: número da tabela de tarifa
   * @return valorDesconto
  **/
  @ApiModelProperty(required = true, value = "Caso tipoDesconto; VALOR: valor do desconto; PORCENTAGEM: porcentagem de desconto; PERMANENCIA: tempo em minutos; MUDANCA_TARIFA: número da tabela de tarifa")
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
    Promocao promocao = (Promocao) o;
    return Objects.equals(this.bandeira, promocao.bandeira) &&
        Objects.equals(this.descricao, promocao.descricao) &&
        Objects.equals(this.diasSemana, promocao.diasSemana) &&
        Objects.equals(this.exigeAutenticacao, promocao.exigeAutenticacao) &&
        Objects.equals(this.horarioFim, promocao.horarioFim) &&
        Objects.equals(this.horarioInicio, promocao.horarioInicio) &&
        Objects.equals(this.imagem, promocao.imagem) &&
        Objects.equals(this.nome, promocao.nome) &&
        Objects.equals(this.quantidadeDisponivel, promocao.quantidadeDisponivel) &&
        Objects.equals(this.regulamento, promocao.regulamento) &&
        Objects.equals(this.systemId, promocao.systemId) &&
        Objects.equals(this.tipoDesconto, promocao.tipoDesconto) &&
        Objects.equals(this.tipoPromocao, promocao.tipoPromocao) &&
        Objects.equals(this.titulo, promocao.titulo) &&
        Objects.equals(this.validade, promocao.validade) &&
        Objects.equals(this.valorAlvo, promocao.valorAlvo) &&
        Objects.equals(this.valorDesconto, promocao.valorDesconto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bandeira, descricao, diasSemana, exigeAutenticacao, horarioFim, horarioInicio, imagem, nome, quantidadeDisponivel, regulamento, systemId, tipoDesconto, tipoPromocao, titulo, validade, valorAlvo, valorDesconto);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Promocao {\n");
    
    sb.append("    bandeira: ").append(toIndentedString(bandeira)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    diasSemana: ").append(toIndentedString(diasSemana)).append("\n");
    sb.append("    exigeAutenticacao: ").append(toIndentedString(exigeAutenticacao)).append("\n");
    sb.append("    horarioFim: ").append(toIndentedString(horarioFim)).append("\n");
    sb.append("    horarioInicio: ").append(toIndentedString(horarioInicio)).append("\n");
    sb.append("    imagem: ").append(toIndentedString(imagem)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    quantidadeDisponivel: ").append(toIndentedString(quantidadeDisponivel)).append("\n");
    sb.append("    regulamento: ").append(toIndentedString(regulamento)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    tipoDesconto: ").append(toIndentedString(tipoDesconto)).append("\n");
    sb.append("    tipoPromocao: ").append(toIndentedString(tipoPromocao)).append("\n");
    sb.append("    titulo: ").append(toIndentedString(titulo)).append("\n");
    sb.append("    validade: ").append(toIndentedString(validade)).append("\n");
    sb.append("    valorAlvo: ").append(toIndentedString(valorAlvo)).append("\n");
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

