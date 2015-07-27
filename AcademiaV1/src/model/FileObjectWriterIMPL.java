package model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileObjectWriterIMPL implements ObjectWriter {
		ObjectOutputStream adaptador;	
	public FileObjectWriterIMPL(File archivo) throws IOException {
		boolean existe=archivo.exists();
		FileOutputStream stream = new FileOutputStream(archivo, existe);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		//-------------------------TRUE------------------------------FALSE--------
		adaptador=existe? new MiObjectOutputStream(buffer) : new ObjectOutputStream(buffer);
	}
	
	@Override
	public void close() throws Exception {
		adaptador.close();
		
	}

	@Override
	public void writeObject(Object input) throws IOException {
		adaptador.writeObject(input);
	}
}
