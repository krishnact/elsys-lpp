/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.elsys;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.himalay.msgs.runtime.*;

@Created(date = "Sun Dec 10 01:13:00 EST 2017")
public class ElsysDataFactory implements Factory {
	public static final int Temperature = 0x01;
	public static final int Humidity = 0x02;
	public static final int Acceleration = 0x03;
	public static final int Light = 0x04;
	public static final int MotionPIR = 0x05;
	public static final int CO2 = 0x06;
	public static final int Battery = 0x07;
	public static final int Analog1 = 0x08;
	public static final int GPS = 0x09;
	public static final int PulseCount = 0x0a;
	public static final int PulseCountABS = 0x0b;
	public static final int ExternalTemp1 = 0x0c;
	public static final int ExternalDigital = 0x0d;
	public static final int ExternalDistance = 0x0e;
	public static final int MotionAccleration = 0x0f;
	public static final int ExternalIRTemp = 0x10;
	public static final int Occupancy = 0x11;
	public static final int ExternalWaterLeak = 0x12;
	public static boolean isDebug = true;
	public static ElsysData lastParsedObject = null;

	public static ElsysData createMsg(DataInputStream istream, AtomicInteger iHolder) throws IOException {
		IntegerHolder iHolder1  =new IntegerHolder();
		ElsysData retVal = createMsg( istream,  iHolder1);
		if ( iHolder != null) {
			iHolder.set(iHolder1.getValue());
		}
		return retVal;
	}
	
	public static ElsysData createMsg(DataInputStream istream, IntegerHolder iHolder1) throws IOException {
		int iRead = 0;
		LPPHeader header;
		{
			int retVal = 0;
			header = new LPPHeader();
			retVal += header.read(istream);
			iRead = retVal;
		}
		ElsysData retVal = createMsg(header, istream, iHolder1);
		iHolder1.setValue(iHolder1.getValue() + iRead);
		return retVal;
	}

	public static ElsysData createMsg(org.himalay.elsys.LPPHeader temp, DataInputStream dis, IntegerHolder iHolder)
			throws IOException {
		int iRead = 0;
		ElsysData retVal = null;
		try {
			switch (temp.getMessageType()) {
			case 0x01: {
				retVal = new Temperature();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x02: {
				retVal = new Humidity();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x03: {
				retVal = new Acceleration();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x04: {
				retVal = new Light();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x05: {
				retVal = new MotionPIR();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x06: {
				retVal = new CO2();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x07: {
				retVal = new Battery();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x08: {
				retVal = new Analog1();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x09: {
				retVal = new GPS();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x0a: {
				retVal = new PulseCount();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x0b: {
				retVal = new PulseCountABS();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x0c: {
				retVal = new ExternalTemp1();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x0d: {
				retVal = new ExternalDigital();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x0e: {
				retVal = new ExternalDistance();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x0f: {
				retVal = new MotionAccleration();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x10: {
				retVal = new ExternalIRTemp();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x11: {
				retVal = new Occupancy();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			case 0x12: {
				retVal = new ExternalWaterLeak();
				retVal.setHeader(temp);
				// has no spread
				iRead += retVal.readNoHeader(dis);
				break;
			}
			}
		} catch (IOException ioex) {
			if (isDebug) {
				lastParsedObject = retVal;
			}
			throw ioex;
		}
		iHolder.setValue(iRead);
		return retVal;
	}

	public static abstract class ElsysData extends BinMessage implements FactoryProduct {
		long sampleTime;
		public ByteArray time;
		public ElsysData() {
			super();
			sampleTime = System.currentTimeMillis();
		}

		public abstract void setHeader(org.himalay.elsys.LPPHeader header);

		public abstract org.himalay.elsys.LPPHeader getHeader();

		@Override
		public void preRead() {
			sampleTime = System.currentTimeMillis();
		}
		
		@Override
		public void postRead() {
			long timeDiff = 0;
			if ( time.getData().length == 1) {
				timeDiff = (time.getData()[0]<< 0)&0x000000ff;
			}else if ( time.getData().length == 2) {
				timeDiff = (time.getData()[0]<< 8)&0x0000ff00|
					       (time.getData()[1]<< 0)&0x000000ff;
			}if ( time.getData().length == 4) {
				timeDiff = (time.getData()[0]<<24)&0xff000000|
					       (time.getData()[1]<<16)&0x00ff0000|
					       (time.getData()[2]<< 8)&0x0000ff00|
					       (time.getData()[3]<< 0)&0x000000ff;
			}else {
				
			}
			timeDiff = timeDiff*1000; //Convert to milliseconds
			sampleTime = sampleTime - timeDiff;
		}
	}
}

// End of code