package com.app.uteqbackend.repository;

import com.app.uteqbackend.model.SliderDet;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ANALISTA-TIC 2
 */
public interface SliderRepository extends JpaRepository<SliderDet, Integer> {

    @Query(value = "SELECT *FROM sl_listado_imagenes_slider_por_tipo_lang(:location,:idSlider);", nativeQuery = true)
    List<SliderDet> getListImagesSliderByIdAndLocation(@Param("location") String location, @Param("idSlider") Integer idSlider);

    @Query("SELECT sd FROM SliderDet sd WHERE sd.sldIdEntidadNotc=?1 AND sd.sldEstado=1 ORDER BY sd.sldOrden ASC")
    public List<SliderDet> getListImagesSliderByEntity(@Param("code") UUID code);

}
