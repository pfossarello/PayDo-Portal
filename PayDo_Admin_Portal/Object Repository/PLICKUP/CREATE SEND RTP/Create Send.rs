<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Create Send</name>
   <tag></tag>
   <elementGuidId>3ab092f4-269e-4fdd-aab4-7d8f124d691d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>${Token}</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;areaCode\&quot;: \&quot;+39\&quot;,\n  \&quot;agentAreaCode\&quot;: \&quot;+39\&quot;,\n  \&quot;disposition\&quot;: \&quot;${disposition}\&quot;,\n  \&quot;methods\&quot;: ${methods},\n  \&quot;currency\&quot;: \&quot;EUR\&quot;,\n  \&quot;language\&quot;: \&quot;${language}\&quot;,\n  \&quot;templates\&quot;: [\n    {\n      \&quot;name\&quot;: \&quot;${name_retail_template}\&quot;,\n      \&quot;channel\&quot;: \&quot;${channel_retail_template}\&quot;,\n      \&quot;recipient\&quot;: \&quot;${recipient_retail_template}\&quot;\n    },\n    {\n      \&quot;name\&quot;: \&quot;${name_agent_template}\&quot;,\n      \&quot;channel\&quot;: \&quot;${channel_agent_template}\&quot;,\n      \&quot;recipient\&quot;: \&quot;${recipient_agent_template}\&quot;\n    }\n  ],\n  \&quot;reason\&quot;: \&quot;${reason}\&quot;,\n  \&quot;expiredAt\&quot;: \&quot;${expiredAt}\&quot;,\n  \&quot;requestCode\&quot;: \&quot;${requestCode}\&quot;,\n  \&quot;payer\&quot;: \&quot;${payer}\&quot;,\n  \&quot;phone\&quot;:\&quot;${phone}\&quot;,\n  \&quot;email\&quot;: \&quot;${email}\&quot;,\n  \&quot;agent\&quot;: \&quot;${agent}\&quot;,\n  \&quot;agentEmail\&quot;: \&quot;${agentEmail}\&quot;,\n  \&quot;agentPhone\&quot;:\&quot;${agentPhone}\&quot;,\n  \&quot;amount\&quot;: \&quot;${amount}\&quot;,\n  \&quot;recurrencyCount\&quot;: \&quot;${recurrencyCount}\&quot;, \n  \&quot;recurrencyDuration\&quot;: \&quot;${recurrencyDuration}\&quot;,\n  \&quot;recurrencyFrequency\&quot;: \&quot;${recurrencyFrequency}\&quot;,\n  \&quot;floaEnrichment\&quot;: \&quot;{\\\&quot;customer\\\&quot;:{\\\&quot;civility\\\&quot;:\\\&quot;Mr\\\&quot;,\\\&quot;firstName\\\&quot;:\\\&quot;Umberto\\\&quot;,\\\&quot;culture\\\&quot;:\\\&quot;it-IT\\\&quot;,\\\&quot;lastName\\\&quot;:\\\&quot;Turano\\\&quot;,\\\&quot;birthDate\\\&quot;:\\\&quot;1983-07-16\\\&quot;,\\\&quot;birthZipCode\\\&quot;:\\\&quot;99\\\&quot;,\\\&quot;homePhoneNumber\\\&quot;:\\\&quot;061523445\\\&quot;,\\\&quot;cellPhoneNumber\\\&quot;:\\\&quot;3456758838\\\&quot;,\\\&quot;reference\\\&quot;:\\\&quot;TestFloaSekurest05\\\&quot;,\\\&quot;email\\\&quot;:\\\&quot;uturano@gmail.com\\\&quot;,\\\&quot;nationalId\\\&quot;: \\\&quot;MRARSS98P28H501A\\\&quot;,\\\&quot;homeAddress\\\&quot;:{\\\&quot;line1\\\&quot;:\\\&quot;Via Nazionale\\\&quot;,\\\&quot;zipCode\\\&quot;:\\\&quot;00184\\\&quot;,\\\&quot;city\\\&quot;:\\\&quot;Roma\\\&quot;,\\\&quot;countryCode\\\&quot;:\\\&quot;IT\\\&quot;},\\\&quot;history\\\&quot;:{\\\&quot;firstOrderDate\\\&quot;:\\\&quot;2022-08-10\\\&quot;,\\\&quot;lastOrderDate\\\&quot;:\\\&quot;2023-12-08\\\&quot;}},\\\&quot;saleChannel\\\&quot;:\\\&quot;Desktop\\\&quot;,\\\&quot;shoppingCarts\\\&quot;:[{\\\&quot;reference\\\&quot;:\\\&quot;YZXK001\\\&quot;,\\\&quot;rawAmount\\\&quot;:1000,\\\&quot;productsCount\\\&quot;:1,\\\&quot;products\\\&quot;:[{\\\&quot;name\\\&quot;:\\\&quot;Travel\\\&quot;,\\\&quot;categories\\\&quot;:[{\\\&quot;name\\\&quot;:\\\&quot;Travel\\\&quot;}],\\\&quot;properties\\\&quot;:[{\\\&quot;name\\\&quot;:\\\&quot;Insurance\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;WWInsurance\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;Type\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;TwoWay\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;DepartureDate\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;2024-07-20\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;ReturnDate\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;2024-07-28\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;DestinationCountryCode\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;BE\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;TravelersCount\\\&quot;,\\\&quot;value\\\&quot;:1},{\\\&quot;name\\\&quot;:\\\&quot;OwnTicket\\\&quot;,\\\&quot;value\\\&quot;:true},{\\\&quot;name\\\&quot;:\\\&quot;MainDepartureCompany\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;AirFrance\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;DepartureAirport\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;CDG\\\&quot;},{\\\&quot;name\\\&quot;:\\\&quot;DestinationAirport\\\&quot;,\\\&quot;value\\\&quot;:\\\&quot;BRU\\\&quot;}],\\\&quot;shipping\\\&quot;:{\\\&quot;method\\\&quot;:\\\&quot;VIR\\\&quot;}}]}],\\\&quot;costa\\\&quot;: true,\\\&quot;gratuito\\\&quot;: true}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>3b150580-c4f0-4c33-8a3c-f603ec3ef7dd</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${Token}</value>
      <webElementGuid>7561948e-ef33-4678-a36f-235c62ebf8ad</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.5.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://server.test.plickup.eu/api/v1/rtps/createAndSend</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.Path</defaultValue>
      <description></description>
      <id>a02a8793-57bc-4db4-bfde-dbcafb3b6801</id>
      <masked>false</masked>
      <name>Environment</name>
   </variables>
   <variables>
      <defaultValue>'eyJraWQiOiJSNFwvZ2dWY3ZZRmhIc1l4eWpnbEFrSGd3c1QwQTZxb0dYTGFqbXhQNUNhcz0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI3ZHJkaXF2cTE5djNudmVybGJoYmFlaDM0aiIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiaHR0cDpcL1wvcnRwLW0ybS1yZXNvdXJjZVwvYXBpLndyaXRlIiwiYXV0aF90aW1lIjoxNzI1MzUxNjMzLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuZXUtd2VzdC0xLmFtYXpvbmF3cy5jb21cL2V1LXdlc3QtMV93Rk5YMjQ2SmUiLCJleHAiOjE3MjUzNTUyMzMsImlhdCI6MTcyNTM1MTYzMywidmVyc2lvbiI6MiwianRpIjoiNjI0ZGIxOGQtMjhlMC00NGQ2LWIxNmQtYjhiMzAwMDk4ZDc4IiwiY2xpZW50X2lkIjoiN2RyZGlxdnExOXYzbnZlcmxiaGJhZWgzNGoifQ.dzoUFGYFFVdENLo6o-wMIXIijmx1gJOITaYveQSisKuenY95oT6DwMjKffo6p9a1ObKpzOq7OZvX3UK40z1KTaRV4YyisU6YwZqNDNql9KWMKfzbszAH7oaqxKP3TeDhQRFFW5rUZRhpw4ZSHq3if4Tl9O_k6HpH_cL-rNneBOE0HKdJtdvGnMwgEvyuE05-2Es1M-nIdUqMkjAU7lhuAbklyceklEW1kbLpzXS-M8Y5B21WwDCLUB65IVPp-UsGU9sHPacztgp04Hn_xC2cCTMU0-TCK0QHK7o1ebh6vgVWA-R6-7QjDNnIIV6PgYWPVfNXB7FUdeeK22r7W8TmLA'</defaultValue>
      <description></description>
      <id>83b858c5-3cf0-4af9-b7d6-a8583b5b7b62</id>
      <masked>false</masked>
      <name>Token</name>
   </variables>
   <variables>
      <defaultValue>['&quot;PISP&quot;']</defaultValue>
      <description></description>
      <id>e95423e4-3596-476b-8543-c9c7a8c0390b</id>
      <masked>false</masked>
      <name>methods</name>
   </variables>
   <variables>
      <defaultValue>'emailRequestRetail'</defaultValue>
      <description></description>
      <id>559ded3a-15f3-4537-bc1b-fd79dc4a2162</id>
      <masked>false</masked>
      <name>name_retail_template</name>
   </variables>
   <variables>
      <defaultValue>'EMAIL'</defaultValue>
      <description></description>
      <id>23f31693-d44f-4a39-b5a5-526a4978a47c</id>
      <masked>false</masked>
      <name>channel_retail_template</name>
   </variables>
   <variables>
      <defaultValue>'RETAIL'</defaultValue>
      <description></description>
      <id>bfb5c640-a744-4e67-b75c-09ca8deba3c4</id>
      <masked>false</masked>
      <name>recipient_retail_template</name>
   </variables>
   <variables>
      <defaultValue>'emailRequestAgent'</defaultValue>
      <description></description>
      <id>0c268e4d-ceb2-4787-a2af-03a51c7cf50a</id>
      <masked>false</masked>
      <name>name_agent_template</name>
   </variables>
   <variables>
      <defaultValue>'EMAIL'</defaultValue>
      <description></description>
      <id>e941883e-07ed-4e80-b5b6-e4123621600e</id>
      <masked>false</masked>
      <name>channel_agent_template</name>
   </variables>
   <variables>
      <defaultValue>'AGENT'</defaultValue>
      <description></description>
      <id>18ca7da4-d24d-4c40-8d10-447e913aedf1</id>
      <masked>false</masked>
      <name>recipient_agent_template</name>
   </variables>
   <variables>
      <defaultValue>'SINGLE'</defaultValue>
      <description></description>
      <id>4d664fb4-b89d-4466-9a08-629e359741b2</id>
      <masked>false</masked>
      <name>disposition</name>
   </variables>
   <variables>
      <defaultValue>'it'</defaultValue>
      <description></description>
      <id>0e505ae5-fcdd-494d-8744-cde6849965a3</id>
      <masked>false</masked>
      <name>language</name>
   </variables>
   <variables>
      <defaultValue>'causale RTP nuova'</defaultValue>
      <description></description>
      <id>2aa0aa5d-4293-4fa0-865d-7a3874d60404</id>
      <masked>false</masked>
      <name>reason</name>
   </variables>
   <variables>
      <defaultValue>'2024-12-08'</defaultValue>
      <description></description>
      <id>5961dd08-5a66-44f7-a5dd-dd58486e98b6</id>
      <masked>false</masked>
      <name>expiredAt</name>
   </variables>
   <variables>
      <defaultValue>'55555'</defaultValue>
      <description></description>
      <id>8cf53cf9-01d7-4579-9d08-6f8b8cdd16c4</id>
      <masked>false</masked>
      <name>requestCode</name>
   </variables>
   <variables>
      <defaultValue>'p.fossarello@quence.it'</defaultValue>
      <description></description>
      <id>2e5d10b5-560c-4488-a8da-5fb27a254673</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>'Pippo Franco'</defaultValue>
      <description></description>
      <id>9bdbb149-ba63-4756-9d61-df206f311b9c</id>
      <masked>false</masked>
      <name>agent</name>
   </variables>
   <variables>
      <defaultValue>'3427484175'</defaultValue>
      <description></description>
      <id>799d1955-8e0c-44bf-8127-2d03ca5e914f</id>
      <masked>false</masked>
      <name>agentPhone</name>
   </variables>
   <variables>
      <defaultValue>'paolofossarello@libero.it'</defaultValue>
      <description></description>
      <id>b8fdfe17-b725-41a8-9cec-05bcfab24dc4</id>
      <masked>false</masked>
      <name>agentEmail</name>
   </variables>
   <variables>
      <defaultValue>'200.04'</defaultValue>
      <description></description>
      <id>5432542a-9846-4845-bf5a-f3d8fc28ec72</id>
      <masked>false</masked>
      <name>amount</name>
   </variables>
   <variables>
      <defaultValue>'3493040270'</defaultValue>
      <description></description>
      <id>fa32c8b8-f83e-4ea9-8609-2cadba57bcfe</id>
      <masked>false</masked>
      <name>phone</name>
   </variables>
   <variables>
      <defaultValue>'Paolo Rossi'</defaultValue>
      <description></description>
      <id>f202b831-c4ca-457a-9e05-d15af356c237</id>
      <masked>false</masked>
      <name>payer</name>
   </variables>
   <variables>
      <defaultValue>'DAILY'</defaultValue>
      <description></description>
      <id>8788d84f-1497-4a90-804f-3f34a453a0b8</id>
      <masked>false</masked>
      <name>recurrencyFrequency</name>
   </variables>
   <variables>
      <defaultValue>2</defaultValue>
      <description></description>
      <id>0cc9d8c0-822c-47c7-a438-67db75f28ef9</id>
      <masked>false</masked>
      <name>recurrencyCount</name>
   </variables>
   <variables>
      <defaultValue>3</defaultValue>
      <description></description>
      <id>f2877398-afab-4a4e-9501-d212f67baab8</id>
      <masked>false</masked>
      <name>recurrencyDuration</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
