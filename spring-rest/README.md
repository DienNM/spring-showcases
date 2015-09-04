# Spring REST Examples

Example of Spring REST:

    - REST stands for Representational State Transfer
    - Based on the foundations of the web’s protocol Hypertext Transfer Protocol (HTTP)
    
    
Showcases:
    
    - usecase1:
        
        + Response in XML Format
        + Using MarshallingView for XML Response
        + Using Jaxb2Marshaller for marshalling data
        
    - usecase2:
    
        + Response in JSON format
        + @RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
        + @ResponseBody
        + In Spring 4+: Using com.fasterxml.jackson.core:jackson-databind
 
    - usecase3:
    
        + Response in XML format
        + @RequestMapping(method = RequestMethod.GET, produces = { "application/xml" })
        + @ResponseBody
        + In Spring 4+: Using com.fasterxml.jackson.core:jackson-databind
    
