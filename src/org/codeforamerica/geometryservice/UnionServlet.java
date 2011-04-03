package org.codeforamerica.geometryservice;

import java.util.Map;

import com.vividsolutions.jts.geom.Geometry;

@SuppressWarnings("serial")
public class UnionServlet extends AbstractGeometryServiceServlet {

	@Override
	public Geometry doOperation(Geometry geom, Map<String, String[]> params) {
		return geom.union();
	}
}
