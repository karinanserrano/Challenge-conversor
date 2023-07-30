package consola;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listas.CargarLista;
import logica.Conversor;
import logica.Objeto;

public class Consola extends javax.swing.JFrame {
	
	public Consola() {		//constructor de la ventana
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //para cerrar la consola cuando se cierre la ventana
		this.setLocationRelativeTo(null);	//inicia la ventana en el centro de la pantalla 
		this.setTitle("Conversor Universal");
		
		iniciarComponentes();
	}

private void iniciarComponentes(){
        
        CargarLista listas = new CargarLista();                                                  // instanciar un objeto CargarLista que contiene una lista de listas con itmes
        
        // --------------------------------------------------paneles   --------------------------------------------------------------
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(236,236,236));
        this.getContentPane().add(panel1);          // agregar panel al frame
        panel1.setLayout(null);                             // desactivar layout de panel
        
        
        JPanel panelMenu = new JPanel();            // panel para el menú
        panelMenu.setBounds(130, 392, 724, 48);
        panelMenu.setBackground(new Color(137,137,137));
        panelMenu.setLayout(null);
        panel1.add(panelMenu);
            
        
        // -------------------------------------------------------- etiquetas -----------------------------
         
         JLabel titulo = new JLabel();                                      // etiqueta de título
         titulo.setText("Conversor ");
         titulo.setFont(new Font("Georgia", Font.BOLD, 35));
         titulo.setBounds(250, 20, 530, 50);
         titulo.setForeground( new Color(71,3,131));
         titulo.setHorizontalAlignment(0);                              // centrar contenido
         panel1.add(titulo);
         
        JLabel etiqueta1 = new JLabel("Convetir de");           // etiquetas de indicaciones
        styleLabel(etiqueta1, 165, 150);
        panel1.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel("Cantidad");
        styleLabel(etiqueta2, 420, 150);
        panel1.add(etiqueta2);
        
        JLabel etiqueta3 = new JLabel("Convertir a");
        styleLabel(etiqueta3, 660, 150);
        panel1.add(etiqueta3);
        
        JLabel resultado = new JLabel();                                                                // etiqueta de resultado
        resultado.setBounds(50, 190, 900, 90);
        resultado.setFont(new Font("Georgia", Font.PLAIN, 25));
        resultado.setHorizontalAlignment(0);
//        resultado.setOpaque(true);
        resultado.setBackground(Color.red);
        resultado.setForeground(new Color(71,3,131));
        panel1.add(resultado);
         
       
        // ------------------------------ combo box  ------------------------------------
        
        JComboBox itemsInicio = new JComboBox();
        styleComboBox(itemsInicio, 100, 110, 250, 35);
         panel1.add(itemsInicio);
        
        JComboBox itemsFinal = new JComboBox();
        styleComboBox(itemsFinal, 590, 110, 250, 35);
        panel1.add(itemsFinal);
        
        
        // --------------------------------------- caja de ingreso  --------------------------------------------------
        
        JTextField cantidad = new JTextField();
        cantidad.setBounds(410, 110, 120, 35);
        cantidad.setFont(new Font("Georgia", Font.BOLD, 25));
        cantidad.setHorizontalAlignment(0);
        cantidad.setForeground(Color.pink);
        cantidad.setText("0");
        cantidad.addKeyListener(soloNumeros());
        panel1.add(cantidad);

        
        //-------------------------------------------------------------------   botones  ---------------------------------------------------
        
          JButton btn6 = new JButton();                                                         // boton para convertir
        btn6.setText("Convertir");
        btn6.setBounds(400, 300, 180, 50);
        btn6.setEnabled(false);
        btn6.setBackground(new Color(0,250,154));
        btn6.setFont(new Font("Georgia", Font.ITALIC, 30));
        btn6.setForeground(new Color(39, 55, 70));
        panel1.add(btn6);
        
        
        JButton btn1 = new JButton();                                               // botones de menú
        styleBoton(btn1, 4, 4, "Moneda");
        panelMenu.add(btn1);
        
       /* JButton btn2 = new JButton();
        styleBoton(btn2, 148, 4, "Liquido");
        panelMenu.add(btn2);
        
        JButton btn3 = new JButton();
        styleBoton(btn3, 292, 4, "Tiempo");
        panelMenu.add(btn3);*/
        
        JButton btn4 = new JButton();
        styleBoton(btn4, 436, 4, "Distancia");
        panelMenu.add(btn4);
        
       /* JButton btn5 = new JButton();
        styleBoton(btn5, 580, 4, "Masa");
        panelMenu.add(btn5);*/
        
        //   ---------------------------------------------  ArrayList que contendrá los botones de menú   ------------------------------------------
        
        ArrayList<JButton> listaBotones = new ArrayList();
        listaBotones.add(btn1);
       /* listaBotones.add(btn2);
        listaBotones.add(btn3);*/
        listaBotones.add(btn4);
       // listaBotones.add(btn5);
        
        
        //  ----------------------------------------------- Agregando eventos a botones de menú  ---------------------------------------------------
        
        btn1.addActionListener(eventoBoton(btn6, itemsInicio, itemsFinal, 0, listas, titulo, cantidad, resultado));
        btn1.addActionListener(cambiarColor(listaBotones, btn1));
        
      /*  btn2.addActionListener(eventoBoton(btn6, itemsInicio, itemsFinal, 3, listas, titulo, cantidad, resultado));
        btn2.addActionListener(cambiarColor(listaBotones, btn2));
        
        btn3.addActionListener(eventoBoton(btn6, itemsInicio, itemsFinal, 2, listas, titulo, cantidad, resultado));
        btn3.addActionListener(cambiarColor(listaBotones, btn3));*/
        
        btn4.addActionListener(eventoBoton(btn6, itemsInicio, itemsFinal, 1, listas, titulo, cantidad, resultado));
        btn4.addActionListener(cambiarColor(listaBotones, btn4));
        
       /* btn5.addActionListener(eventoBoton(btn6, itemsInicio, itemsFinal, 4, listas, titulo, cantidad, resultado));
        btn5.addActionListener(cambiarColor(listaBotones, btn5));*/
    }

private void styleBoton(JButton btn, int x, int y, String texto){
    btn.setLocation(x, y);
    btn.setText(texto);
    btn.setFont(new Font("Georgia", Font.ITALIC, 24));
    btn.setSize(140, 40);
    
    styleB1(btn);
}

private void styleB1(JButton btn){
btn.setForeground(new Color(234, 236, 238));
btn.setBackground(new Color(83, 118, 122));
}

private void styleB2(JButton btn){
btn.setForeground(new Color(83, 118, 122));
btn.setBackground(new Color(169,169,169));
}

private void styleComboBox(JComboBox a1, int x, int y, int a, int h){
    a1.setFont(new Font("Georgia", Font.ITALIC, 18));
    a1.setBounds(x, y, a, h);
    a1.setBackground(new Color(127,255,212));
}

private void styleLabel(JLabel etiqueta, int x, int y){
etiqueta.setLocation(x, y);
etiqueta.setSize(130, 30);
etiqueta.setFont(new Font("Georgia", Font.ITALIC, 22));
etiqueta.setForeground(Color.LIGHT_GRAY);
}



//  --------------------------------------------  eventos   -----------------------------------------------------------------

 /**
  * Recorremos cada elemento de la lista y la agregamos como item de ambos combo box
  * @param q1   comboBox1, sirve para seleccionar la unidad de inicio
  * @param q2  comboBox2, sirva para seleccionar la unidad final
  * @param li     parametro de tipo ListaGeneral
  * @param j      indice de la lista
  */

private void llenarComboBox(JComboBox q1, JComboBox q2, CargarLista li, int j){
for(int i=0; i<li.getLista(j).getTamanio(); i++){                
    q1.addItem(li.getLista(j).obtenerObjeto(i).getObjetoDe());          // agregamos item
    q2.addItem(li.getLista(j).obtenerObjeto(i).getObjetoDe());
}
}

/**
* Agregamos el título, cada lista de la ListaGeneral contiene un atributo que funciona como su nombre, accedemos a 
* ella y la mostramos
* @param titulo    label donde se muestra el título
* @param lista       parametro de tipo ListaGeneral
* @param indice    índice de la lista
*/

private void setTitulo(JLabel titulo, CargarLista lista, int indice){
titulo.setText("Conversor de " + lista.getLista(indice).obtenerNombreLista());
}

/**
* Evento que funciona como menú.
*  Con este evento cambiamos los items de cada combo box, tambien agregamos el evento principal al boton convertir, que permite 
* realizar las conversones y, por último también cambiamos el título
* 
* Este evento invoca a otros eventos, por ello necesitamos muchos parametros
* 
* @param ejecutar      botón a quién se le asigna el evento convertir
* @param jcb1              comboBox1
* @param jcb2              comboBox2
* @param indice          indice de lista 
* @param lista             lista de listas
* @param titulo            etiqueta que tiene el título, el cual cambiamos cada vez que cambiamos de tipo de conversor
* @param caja              textField que recibe la cantidad que el usuario desea convertir
* @param respuesta  etiqueta donde se mostrara el resultado de la conversión
* @return                      retornamos un ActionListener
*/

private ActionListener eventoBoton(JButton ejecutar, JComboBox jcb1, JComboBox jcb2, int indice, CargarLista lista, JLabel titulo, JTextField caja, JLabel respuesta){

    ActionListener evento = new ActionListener(){       // implementamos una interfaz ActionListener
        @Override
        public void actionPerformed(ActionEvent e) {        // implementamos sus métodos
            respuesta.setText(" ");                 // limpiamos la etiqueta de respuesta
            caja.setText("0");
            
            ejecutar.addMouseListener(eventoConvertir(jcb1, jcb2, indice, caja, respuesta, lista));     // agregamos un evento al botón ejecutar
            ejecutar.setEnabled(true);              // encedemos el botón
            
            setTitulo(titulo, lista, indice);           // llamamos al método setTitulo, 
        
            jcb1.removeAllItems();          // limpiar items de combo box
            jcb2.removeAllItems();
        
           llenarComboBox(jcb1, jcb2, lista, indice);       // llenamos los comboBox
    }
    
};

return evento;

}



/**
* Evento que usaremos para cambiar el estilo del boton que pulsemos, recorremos una lista de botones y comparamos cada boton,
* si es el boton que precionamos le cambiamos el estilo
* @param botones           lista de botones
* @param botonAction       boton que precionado
* @return 
*/

private ActionListener cambiarColor(ArrayList<JButton> botones, JButton botonAction){
ActionListener eventoC = new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton b: botones){
            if(b.equals(botonAction)){
                styleB2(b);
            }else{
                styleB1(b);
            }
        }
    }
    
};
return eventoC;
}






/**
* Este evento realiza la conversión, primero guardamos en variables los parametros necesarios para instanciar un objeto de la clase
* conversor, una vez instanciada invocamos al método convertir
* @param inicio            comboBox de inicio
* @param terminar      comboBox de final
* @param indice            indice de lista
* @param caja                 textfield que contine la cantidad a convertir
* @param etiquetaRespuesta     etiqueta donde mostramos el resultado de la conversión
* @param lis                   lista que contiene otras listas
* @return                          retornamos un evento de tipo MouseListener
*/

private MouseListener eventoConvertir(JComboBox inicio, JComboBox terminar, int indice, JTextField caja, JLabel etiquetaRespuesta, CargarLista lis){
MouseListener evento1 = new MouseListener() {        // implementamos la interfaz mouseListener e implementamos sus métodos
    @Override                                                                           
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        Objeto convertDe = lis.getLista(indice).obtenerObjeto(inicio.getSelectedIndex());         // guardamos el elemento inicial
        Objeto convertA = lis.getLista(indice).obtenerObjeto(terminar.getSelectedIndex());        // guardamos el elemento final
        double cantidad = Double.parseDouble(caja.getText());           // guardamos la cantidad
    
        Conversor con1 = new Conversor(convertDe, convertA, cantidad);          // instanciamos un objeto de tipo Conversor
    
         // llamamos al método converir y el resultado lo guardamos como string con un formato de solo 2 dígitos
         String resultadoTexto = String.valueOf(String.format("%.2f", con1.convertir()));      
        String cantidadTexto = String.valueOf(cantidad);        // guardamos la cantidad como string
        
        String nombreEleInicio =  convertDe.getObjetoA();    // variables que contendran los nombres de los elementos
        String nombreEleFinal = convertA.getObjetoA();
        
       
        if(cantidad == 1){                  // agregamos condicionales para determinar si usamos las unidades en plural o singular
             nombreEleInicio = convertDe.getObjetoDe();
        }
        
        if(resultadoTexto.equals("1.00")){
            nombreEleFinal = convertA.getObjetoDe();
        } 
        
        // mostramos el resultado
        etiquetaRespuesta.setText(cantidadTexto +" "+ nombreEleInicio + " equivale a : " + resultadoTexto + " " + nombreEleFinal );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

};

return evento1;
}


/**
* Este método nos permite limitar el ingreso de caracteres al textField, unicamente se pueden ingresar números, para ello
* usarmos un evento de teclado
* @return     retornamos un evento de teclado
*/

private KeyListener soloNumeros(){
KeyListener evento = new KeyListener(){         //implementamos un evento de teclado con sus métodos
    @Override
    public void keyTyped(KeyEvent e) {
        int tecla = e.getKeyChar();      // creamos una variable entera que guardará el código ascii de la tecla que precionemos 
        
        // creamos una variable booleana que es verdadera si la variable tecla está entre los límites indicados
        boolean valido = (tecla >= 48 && tecla <=57) ;          
        
        if(!valido){            // si la varible booleana es falsa, el evento solo se consume y ingresa en el textField
            e.consume();
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }       // eventos si usar

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
};

return evento;
}

}