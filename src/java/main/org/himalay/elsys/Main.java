package org.himalay.elsys;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;

import org.himalay.msgs.runtime.ByteArray;
import org.himalay.msgs.runtime.DumpContext;
import org.himalay.msgs.runtime.IntegerHolder;

public class Main {
	
	public static void main(String[] args) {
		String data = "0x01,0x00,0xcd,0x41, 0x00,0xcd,0x0a,0xc1," + 
				      "0x00,0xcd,0x00,0x01, 0x51,0x80,0x01,0x00," + 
				      "0xcd,0x41,0x01,0x0c, 0x0a";
		
		DataInputStream dais = DumpContext.dataInputStream(data);
		IntegerHolder ih = new IntegerHolder();
		
		ElsysDataFactory.ElsysData dataPacket = null;
		while ( true) {
			try {
				dataPacket = ElsysDataFactory.createMsg(dais, ih);
				System.out.println(new Date(dataPacket.sampleTime));
				dataPacket.dump();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}
