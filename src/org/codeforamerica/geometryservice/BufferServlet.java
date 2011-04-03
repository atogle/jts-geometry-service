package org.codeforamerica.geometryservice;

import java.util.Map;

import com.vividsolutions.jts.geom.*;

@SuppressWarnings("serial")
public class BufferServlet extends AbstractGeometryServiceServlet {
	
	@Override
	public Geometry doOperation(Geometry geom, Map<String, String[]> params) {
		double bufferDist = Double.parseDouble(params.get("d")[0]);
		return geom.buffer(bufferDist);
	}
}
