package org.codeforamerica.geometryservice;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.*;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

@SuppressWarnings("serial")
public abstract class AbstractGeometryServiceServlet extends HttpServlet {
	public static WKTReader wktReader = new WKTReader();
	public static WKTWriter wktWriter = new WKTWriter();	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String respStr = "";
		String wkt = req.getParameter("wkt");
		Geometry inputGeom = null;
		
		try {
			inputGeom = wktReader.read(wkt);
			@SuppressWarnings("unchecked")
			Geometry outputGeom = doOperation(inputGeom, req.getParameterMap());
			
			respStr = wktWriter.write(outputGeom);
		} catch(ParseException pe) {
			respStr = "Error parsing WKT.";
		}

		resp.setContentType("text/plain");
		resp.getWriter().println(respStr);
	}
	
	public abstract Geometry doOperation(Geometry geom, Map<String, String[]> params);
}
