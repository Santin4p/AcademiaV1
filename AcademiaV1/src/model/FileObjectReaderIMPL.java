package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileObjectReaderIMPL implements ObjectReader {
	ObjectInputStream adaptador;
	public FileObjectReaderIMPL(File archivo) throws IOException {
		FileInputStream stream=new FileInputStream(archivo);
		BufferedInputStream buffer=new BufferedInputStream(stream);
		adaptador=new ObjectInputStream(buffer);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void close() throws Exception {
		adaptador.close();
		
	}
	@Override
	public Object nextObject() throws IOException {
		try {
			return adaptador.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
