/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipfl;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author angelraymundo
 */
public class JuegoBS extends JFrame implements ActionListener {
    JButton[][] _field = new JButton[10][10];
    char[][] _datos1 = new char[10][10];
    char[][] _datos2 = new char[10][10];
    JButton _ok,_nel,_kuatro,_tres,_dos,_uno;
    JLabel _titu;
    int op,bar,cont;
    public JuegoBS(){
        Vent();
        Inicializar();
        Inicio();
        setVisible(true);
    }
    private void Inicializar(){
        _titu = new JLabel();
        _titu.setLayout(null);
        add(_titu);
        _ok=new JButton();
        _ok.setLayout(null);
        _ok.addActionListener(this);
        add(_ok);
        _kuatro=new JButton();
        _kuatro.setLayout(null);
        _kuatro.addActionListener(this);
        add(_kuatro);
        _tres=new JButton();
        _tres.setLayout(null);
        _tres.addActionListener(this);
        add(_tres);
        _dos=new JButton();
        _dos.setLayout(null);
        _dos.addActionListener(this);
        add(_dos);
        _uno=new JButton();
        _uno.setLayout(null);
        _uno.addActionListener(this);
        add(_uno);
        _nel=new JButton();
        _nel.setLayout(null);
        _nel.addActionListener(this);
        add(_nel);
        for(int fil=0;fil<10;fil++){
            for(int col=0;col<10;col++){
                _field[fil][col]=new JButton();
                
                _field[fil][col].setVisible(false);
                _field[fil][col].addActionListener(this);
                add(_field[fil][col]);
            }
        }
    }
    private void Vent(){
        setTitle("AhorcadoFL");
        setLayout(null);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    private void Inicio(){
        op=0;
        
        _titu.setText("Seleccione una opcion");
        _titu.setFont(new Font("Tahoma", Font.BOLD, 35));
        _titu.setBounds(300, 50, 500, 50);
        
        _ok.setText("Comienze el Juego");
        _ok.setBounds(100, 300, 350, 200);
        
        _nel.setText("Datos");
        _nel.setBounds(550, 300, 350, 200);
        
    }
    private void Campo(){
        op=1;
        _titu.setText("Indique sus barcos (J1)");
        _titu.setFont(new Font("Tahoma", Font.BOLD, 20));
        _titu.setBounds(400,20, 500, 50);
        for(int fil=0;fil<10;fil++){
            for(int col=0;col<10;col++){
                
                _field[fil][col].setText(" ");
                _field[fil][col].setBounds(200+fil*60,100+col*60,45,45);
                _field[fil][col].setVisible(true);
                
            }
        }
        _kuatro.setVisible(true);
        _tres.setVisible(true);
        _dos.setVisible(true);
        _uno.setVisible(true);
        _kuatro.setText("Barco de 4");
        _kuatro.setBounds(20, 100,150, 30);
        _tres.setText("Barco de 3");
        _tres.setBounds(20, 150,150, 30);
        _dos.setText("Barco de 2");
        _dos.setBounds(20, 200,150, 30);
        _uno.setText("Barco de 1");
        _uno.setBounds(20, 250,150, 30);
        _ok.setText("sig");
        _ok.setBounds(100, 750, 100, 20);
        
        _nel.setText("Regresar");
        _nel.setBounds(550, 750, 100, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==_ok){
            if(op==0){
              Campo();  
            }else if(op==1){
                for(int fil=0;fil<10;fil++){
                    for(int col=0;col<10;col++){
                        
                        if(!_field[fil][col].getText().equals(" ")){
                            _datos1[fil][col]='o';
                        }
                        
                    }
                }
                op=2;
                Campo();
                _titu.setText("Indique sus barcos (J2)");
            }else if(op==2){
                
                for(int fil=0;fil<10;fil++){
                    for(int col=0;col<10;col++){
                        
                        if(!_field[fil][col].getText().equals(" ")){
                            _datos2[fil][col]='o';
                        }
                        
                    }
                }
            }
            
        }else if(e.getSource()==_nel){
            if(op==1){
                Inicio();
                for(int fil=0;fil<10;fil++){
                    for(int col=0;col<10;col++){
                        
                        _field[fil][col].setVisible(false);
                        
                    }
                }
                _kuatro.setVisible(false);
                _tres.setVisible(false);
                _dos.setVisible(false);
                _uno.setVisible(false);
            }
        }else if(e.getSource()==_kuatro){
            bar=4;
        }else if(e.getSource()==_tres){
            bar=3;
        }else if(e.getSource()==_dos){
            bar=2;
        }else if(e.getSource()==_uno){
            bar=1;
        }
        if(bar==4){
            cont=0;
            for(int fil=0;fil<10;fil++){
                for(int col=0;col<10;col++){
                    if(e.getSource()==_field[fil][col]){
                        if(cont==0){
                            _field[fil][col].setText("o");
                        }else{
                            if(_field[fil][col].getText().equals("o")){
                                _field[fil][col].setText(" ");
                            }else if(_field[fil][col].getText().equals(" ")){
                                if(_field[fil+1][col].getText().equals("o")||_field[fil-1][col].getText().equals("o")||_field[fil][col+1].getText().equals("o")||_field[fil][col-1].getText().equals("o")){
                                    _field[fil][col].setText("o");
                                } 
                            }
                        }
                    }
                    if(_field[fil][col].getText().equals("o")){
                        cont++;
                        if(cont==4){
                            bar=0;
                        }
                    }  
                }
            }
        }
        if(bar==3){
            cont=0;
            for(int fil=0;fil<10;fil++){
                for(int col=0;col<10;col++){
                    if(e.getSource()==_field[fil][col]){
                        if(cont==0){
                            _field[fil][col].setText("x");
                        }else{
                            if(_field[fil][col].getText().equals("x")){
                                _field[fil][col].setText(" ");
                            }else if(_field[fil][col].getText().equals(" ")){
                                    if(_field[fil+1][col].getText().equals("x")||_field[fil-1][col].getText().equals("x")||_field[fil][col+1].getText().equals("x")||_field[fil][col-1].getText().equals("x")){
                                        _field[fil][col].setText("x");
                                    } 
                                }
                        }
                    }
                    if(_field[fil][col].getText().equals("x")){
                        cont++;
                        if(cont==3){
                            bar=0;
                        }
                    }  
                }
            }
        }
        if(bar==2){
            cont=0;
            for(int fil=0;fil<10;fil++){
                for(int col=0;col<10;col++){
                    if(e.getSource()==_field[fil][col]){
                        if(cont==0){
                            _field[fil][col].setText("*");
                        }else{
                            if(_field[fil][col].getText().equals("*")){
                                _field[fil][col].setText(" ");
                            }else if(_field[fil][col].getText().equals(" ")){
                                    if(_field[fil+1][col].getText().equals("*")||_field[fil-1][col].getText().equals("*")||_field[fil][col+1].getText().equals("*")||_field[fil][col-1].getText().equals("*")){
                                        _field[fil][col].setText("*");
                                    } 
                                }
                        }
                    }
                    if(_field[fil][col].getText().equals("*")){
                        cont++;
                        if(cont==2){
                            bar=0;
                        }
                    }  
                }
            }
        }
        if(bar==1){
            cont=0;
            for(int fil=0;fil<10;fil++){
                for(int col=0;col<10;col++){
                    if(e.getSource()==_field[fil][col]){
                        if(cont==0){
                            _field[fil][col].setText("+");
                        }else{
                            if(_field[fil][col].getText().equals("+")){
                                _field[fil][col].setText(" ");
                            }else if(_field[fil][col].getText().equals(" ")){
                                    if(_field[fil+1][col].getText().equals("+")||_field[fil-1][col].getText().equals("+")||_field[fil][col+1].getText().equals("+")||_field[fil][col-1].getText().equals("+")){
                                        _field[fil][col].setText("+");
                                    } 
                                }
                        }
                    }
                    if(_field[fil][col].getText().equals("+")){
                        cont++;
                        if(cont==1){
                            bar=0;
                        }
                    }  
                }
            }
        }
    }
}
