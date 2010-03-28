package odata4j.producer.resources;

import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import odata4j.core.ODataConstants;
import odata4j.edm.EdmDataServices;
import odata4j.producer.ODataProducer;
import odata4j.xml.EdmxWriter;

@Path("{first: \\$}metadata")
public class MetadataResource {

	
	@GET
	@Produces(ODataConstants.APPLICATION_XML_CHARSET)
	public Response getMetadata(@Context ODataProducer producer){
		
		EdmDataServices s = producer.getMetadata();
		
		StringWriter w = new StringWriter();
		EdmxWriter.write(s, w);
		
		return Response.ok(w.toString(),ODataConstants.APPLICATION_XML_CHARSET).header("DataServiceVersion","1.0").build();
	}
}
