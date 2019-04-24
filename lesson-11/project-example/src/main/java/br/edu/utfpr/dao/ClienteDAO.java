package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import br.edu.utfpr.dto.ClienteDTO;
import lombok.extern.java.Log;

@Log
public class ClienteDAO {

    // Responsável por criar a tabela Cliente no banco.
    public ClienteDAO() {

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Criando tabela cliente ...");
            conn.createStatement().executeUpdate(
                    "CREATE TABLE cliente (" +
                            "id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_cliente_pk PRIMARY KEY," +
                            "nome varchar(255)," +
                            "telefone varchar(30)," +
                            "idade int," +
                            "limiteCredito double," +
                            "id_pais int)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Responsável pela inserção de cliente.
    public void Inserir(ClienteDTO cliente) {

        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Inserir na tabela cliente");
            String sql = "INSERT INTO cliente ( id, nome, telefone, idade, limiteCredito, id_pais) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(client.id);
            statement.setString(cliente.nome);
            statement.setString(cliente.telefone);
            statement.setInt(cliente.idade);
            statement.setDouble(cliente.limiteCredito);
            statement.setInt(cliente.id_pais);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    //Responsável pela alteração do cliente.
    public void Alterar(ClienteDTO cliente) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Alterar um cliente");
            String sql = "UPDATE cliente SET nome=?, telefone=?, idade=?, limiteCredito=?, id_pais=? WHERE id=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(cliente.);
            statement.setString(cliente.nome);
            statement.setString(cliente.telefone);
            statement.setInt(cliente.idade);
            statement.setDouble(cliente.limiteCredito);
            statement.setInt(cliente.id_pais);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    //Responsável pela consulta de um cliente.
    public List<Cliente> Consultar() {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {
            List<Cliente> clientes = new ArrayList<>;
            log.info("Consultar tabela cliente");
            String sql = "SELECT * FROM cliente";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(cliente.id)

            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.nome = result.getString("nome");
                cliente.telefone = result.getString("telefone");
                cliente.idade = result.getInt("idade");
                cliente.limiteCredito = result.getDouble("limiteCredito");
                cliente.id_pais = result.getInt("id_pais");
                clientes[count] = cliente;
                count++;
            }
            return clientes;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Responsável por deletar um cliente.
    public void Deletar(ClienteDTO cliente) {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {

            log.info("Deletar um cliente");
            String sql = "DELETE FROM cliente WHERE id=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(cliente.id)

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
