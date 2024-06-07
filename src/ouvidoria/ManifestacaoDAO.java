package ouvidoria;

import exception.ConexaoFalhouException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManifestacaoDAO {

    public void criarManifestacao(Manifestacao manifestacao) {
        String SQL = "INSERT INTO manifestacao (tipoManifestacao, nomeManifestante, manifestacao) VALUES (?, ?, ?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, manifestacao.getTipoManifestacao());
            pstmt.setString(2, manifestacao.getNomeManifestante());
            pstmt.setString(3, manifestacao.getTextoManifestacao());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
            throw new ConexaoFalhouException(e);
            //System.out.println(e.getMessage());
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
}