package ouvidoria;

import exception.ConexaoFalhouException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManifestacaoDAO {

    public int criarManifestacao(Manifestacao manifestacao) {
        String SQL = "INSERT INTO manifestacao (tipoManifestacao, nomeManifestante, manifestacao) VALUES (?, ?, ?)";
        int linhasAfetadas = 0;
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, manifestacao.getTipoManifestacao());
            pstmt.setString(2, manifestacao.getNomeManifestante());
            pstmt.setString(3, manifestacao.getTextoManifestacao());
            linhasAfetadas = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return linhasAfetadas;
    }

    public List<Manifestacao> listarTodasAsManifestacoes() throws ConexaoFalhouException {
        List<Manifestacao> manifestacoes = new ArrayList<>();
        String SQL = "SELECT * FROM manifestacao";
        try(Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL)) {

            while(resultSet.next()) {
                int idManifestacao = resultSet.getInt("idManifestacao");
                String tipoManifestacao = resultSet.getString("tipoManifestacao");
                String nomeManifestante = resultSet.getString("nomeManifestante");
                String manifestacao = resultSet.getString("manifestacao");
                manifestacoes.add(new Manifestacao(idManifestacao, tipoManifestacao, nomeManifestante, manifestacao));
            }

        } catch (SQLException e) {
            throw new ConexaoFalhouException("Erro na conexão com o banco de dados ao listar todas as manifestações: ", e);
        }
        return manifestacoes;
    }

    public List<Manifestacao> listarManifestacoesPorTipo(String tipoStr) {
        List<Manifestacao> manifestacoesEncontradas = new ArrayList<>();
        String SQL = "SELECT * FROM manifestacao WHERE tipoManifestacao = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            preparedStatement.setString(1, tipoStr);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int idManifestacao = resultSet.getInt("idManifestacao");
                String tipoManifestacao = resultSet.getString("tipoManifestacao");
                String nomeManifestante = resultSet.getString("nomeManifestante");
                String manifestacao = resultSet.getString("manifestacao");
                manifestacoesEncontradas.add(new Manifestacao(idManifestacao, tipoManifestacao, nomeManifestante, manifestacao));
            }

        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
        return manifestacoesEncontradas;
    }

    public Manifestacao buscarManifestacaoPorId(int id) throws ConexaoFalhouException {
        Manifestacao manifestacao = null;
        String SQL = "SELECT * FROM manifestacao WHERE idManifestacao = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String tipoManifestacao = resultSet.getString("tipoManifestacao");
                String nomeManifestante = resultSet.getString("nomeManifestante");
                String textoManifestacao = resultSet.getString("manifestacao");
                manifestacao = new Manifestacao(id, tipoManifestacao, nomeManifestante, textoManifestacao);
            }

        } catch (SQLException e) {
            throw new ConexaoFalhouException("Erro na conexão com o banco de dados ao buscar manifestação por ID: ", e);
        }

        return manifestacao;
    }

    public int excluirManifestacao(int idProcurado) throws ConexaoFalhouException {
        String SQL = "DELETE FROM manifestacao WHERE idManifestacao = ?";
        int linhasAfetadas;
        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idProcurado);
            linhasAfetadas = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new ConexaoFalhouException("Erro na conexão com o banco de dados ao listar todas as manifestações: ", e);
        }
        return linhasAfetadas;
    }

    public int exibirQuantidadeDeManifestacoes() throws ConexaoFalhouException {
        String SQL = "SELECT COUNT(*) FROM manifestacao";
        int quantidadeDeManifestacoes = 0;
        try(Connection conn = DatabaseConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL)) {
            //quantidadeDeManifestacoes = resultSet.getInt("COUNT(*)");
            if(resultSet.next()) {
                quantidadeDeManifestacoes = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new ConexaoFalhouException("Erro na conexão com o banco de dados ao consultar a quantidade de manifestações cadastradas: ", e);
        }

        return quantidadeDeManifestacoes;
    }

}