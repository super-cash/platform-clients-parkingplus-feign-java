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


package cash.super_.platform.client.parkingplus.invoker;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-10T22:06:45.404Z")
public class StringUtil {
  /**
   * Check if the given array contains the given value (with case-insensitive comparison).
   *
   * @param array The array
   * @param value The value to search
   * @return true if the array contains the value
   */
  public static boolean containsIgnoreCase(String[] array, String value) {
    for (String str : array) {
      if (value == null && str == null) return true;
      if (value != null && value.equalsIgnoreCase(str)) return true;
    }
    return false;
  }

  /**
   * Join an array of strings with the given separator.
   * <p>
   * Note: This might be replaced by utility method from commons-lang or guava someday
   * if one of those libraries is added as dependency.
   * </p>
   *
   * @param array     The array of strings
   * @param separator The separator
   * @return the resulting string
   */
  public static String join(String[] array, String separator) {
    int len = array.length;
    if (len == 0) return "";

    StringBuilder out = new StringBuilder();
    out.append(array[0]);
    for (int i = 1; i < len; i++) {
      out.append(separator).append(array[i]);
    }
    return out.toString();
  }
}
