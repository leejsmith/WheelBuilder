package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Data {
	private ArrayList<Hub> hubList;
	private ArrayList<Rim> rimList;

	public Data() {
		File rimFile = new File("./rims.xml");

		if (rimFile.exists() && !rimFile.isDirectory()) {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;
			try {
				docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(rimFile);

				doc.getDocumentElement().normalize();

				NodeList nList = doc.getElementsByTagName("rim");

				rimList = new ArrayList<Rim>();

				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						int rimID = Integer.parseInt(eElement.getAttribute("rimID"));
						String rimName = eElement.getElementsByTagName("rimName").item(0).getTextContent();
						int rimDiam = Integer.parseInt(eElement.getElementsByTagName("rimDiameter").item(0).getTextContent());
						int rimWidth = Integer.parseInt(eElement.getElementsByTagName("rimWidth").item(0).getTextContent());
						int rimDepth = Integer.parseInt(eElement.getElementsByTagName("rimDepth").item(0).getTextContent());
						int rimHole = Integer.parseInt(eElement.getElementsByTagName("rimHole").item(0).getTextContent());
						int rimStockQuant = Integer.parseInt(eElement.getElementsByTagName("rimStockQuant").item(0).getTextContent());
						Rim rim = new Rim(rimID, rimName, rimDiam, rimWidth, rimDepth, rimHole, rimStockQuant);

						this.addNewRim(rim);
					}
				}

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			this.rimList = new ArrayList<Rim>();
		}

		File hubFile = new File("./hubs.xml");

		if (hubFile.exists() && !hubFile.isDirectory()) {

		} else {
			this.hubList = new ArrayList<Hub>();
		}
	}

	public void addNewHub(Hub newHub) {
		hubList.add(newHub);
	}

	public void addNewRim(Rim newRim) {
		rimList.add(newRim);
	}

	public void writeRims() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("WheelBuilder");

			doc.appendChild(rootElement);

			for (Rim r : rimList) {
				Element rim = doc.createElement("rim");
				rootElement.appendChild(rim);

				Attr attr = doc.createAttribute("rimID");  //set attribute of the xml node to the ID of the rim
				attr.setValue(String.valueOf(r.getRimID()));
				rim.setAttributeNode(attr);

				Element name = doc.createElement("rimName"); //adds the rim name to the node
				name.appendChild(doc.createTextNode(String.valueOf(r.getRimName())));
				rim.appendChild(name);

				Element diam = doc.createElement("rimDiameter"); //adds the diameter of the rim to the node
				diam.appendChild(doc.createTextNode(String.valueOf(r.getRimDiameter())));
				rim.appendChild(diam);

				Element width = doc.createElement("rimWidth"); //adds the width of the rim to the node
				width.appendChild(doc.createTextNode(String.valueOf(r.getRimWidth())));
				rim.appendChild(width);

				Element depth = doc.createElement("rimDepth"); //adds the depth of the rim to the node
				depth.appendChild(doc.createTextNode(String.valueOf(r.getRimDepth())));
				rim.appendChild(depth);

				Element holes = doc.createElement("rimHole"); //adds the number of holes in the rim to the node
				holes.appendChild(doc.createTextNode(String.valueOf(r.getRimHole())));
				rim.appendChild(holes);

				Element quant = doc.createElement("rimStockQuant"); //adds the current stock quantity of the rim to the node
				quant.appendChild(doc.createTextNode(String.valueOf(r.getRimStockQuant())));
				rim.appendChild(quant);
			}
			XMLFileWrite(doc, "rims");
		} catch (IndexOutOfBoundsException ioob) {
			System.out.println("Rims List Empty");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeHubs() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("WheelBuilder");

			doc.appendChild(rootElement);

			for (Hub h : hubList) {
				Element hub = doc.createElement("hub");
				rootElement.appendChild(hub);

				Attr attr = doc.createAttribute("hubID");  //set attribute of the xml node to the ID of the rim
				attr.setValue(String.valueOf(h.getHubID()));
				hub.setAttributeNode(attr);

				Element name = doc.createElement("hubName"); //adds the rim name to the node
				name.appendChild(doc.createTextNode(String.valueOf(h.getHubName())));
				hub.appendChild(name);

				Element driveDiam = doc.createElement("hubDriveDiameter"); //adds the diameter of the rim to the node
				driveDiam.appendChild(doc.createTextNode(String.valueOf(h.getFlangeDiameterDrive())));
				hub.appendChild(driveDiam);

				Element nonDriveDiam = doc.createElement("hubNonDriveDiameter"); //adds the width of the rim to the node
				nonDriveDiam.appendChild(doc.createTextNode(String.valueOf(h.getFlangeDiameterNonDrive())));
				hub.appendChild(nonDriveDiam);

				Element distance = doc.createElement("hubDistance"); //adds the depth of the rim to the node
				distance.appendChild(doc.createTextNode(String.valueOf(h.getFlangeDistance())));
				hub.appendChild(distance);

				Element dished = doc.createElement("hubDished"); //adds the number of holes in the rim to the node
				dished.appendChild(doc.createTextNode(String.valueOf(h.isDished())));
				hub.appendChild(dished);

				Element hubType = doc.createElement("hubType"); //adds the current stock quantity of the rim to the node
				hubType.appendChild(doc.createTextNode(String.valueOf(h.getHubType().name())));
				hub.appendChild(hubType);
				
				Element hubHole = doc.createElement("hubHole"); //adds the current stock quantity of the rim to the node
				hubHole.appendChild(doc.createTextNode(String.valueOf(h.getHubHole())));
				hub.appendChild(hubHole);
				
				Element hubStockQuant = doc.createElement("hubStockQuant"); //adds the current stock quantity of the rim to the node
				hubStockQuant.appendChild(doc.createTextNode(String.valueOf(h.getHubStockQuant())));
				hub.appendChild(hubStockQuant);
			}
			XMLFileWrite(doc, "hubs");
		} catch (IndexOutOfBoundsException ioob) {
			System.out.println("Hubs List Empty");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void XMLFileWrite(Document doc, String fileName) {

		try {
			TransformerFactory transFact = TransformerFactory.newInstance();
			Transformer transformer = transFact.newTransformer();

			DOMSource source = new DOMSource(doc);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			StreamResult result = new StreamResult(new File("./" + fileName + ".xml"));

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
