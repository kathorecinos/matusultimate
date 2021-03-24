package Activitys

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.matusintl.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class Find : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)
        createFragment()
    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        try {
            val isAdded =
                googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle))

            Log.e("MAPS ACTIVITY", "IS THE MAP ADDED ? $isAdded")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val polyline1 = googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .color(R.color.colorPrimaryDark)
                .endCap(RoundCap())
                .add(
                    LatLng(33.78050382614036, -118.20337330596534),
                    LatLng(33.7551475743488, -118.21632928555647),
                    LatLng(11.970694, -106.771554),
                    LatLng(13.7835293470295, -89.20225766001776)
                )
        )



        createMarkerElSalvadorCaliRansa()
        createMarkerElSalvadorCaliNe()
        createMarkerElSalvadorCaliSanBar()
        createMarkerElSalvadorCaliTrans()
        createMarkerElSalvadorFloRansa()
        createMarkerElSalvadorFloNe()
        createMarkerElSalvadorFloSanBar()
        createMarkerElSalvadorFloTrans()
        createMarkerGuatemalaCaliCoalsa()
        createMarkerGuatemalaCaliCentralsa()
        createMarkerGuatemalaCaliStoTomas()
        createMarkerGuatemalaCaliPtoBar()
        createMarkerGuatemalaFloCoalsa()
        createMarkerGuatemalaFloCentralsa()
        createMarkerGuatemalaFloStoTomas()
        createMarkerGuatemalaFloPtoBar()
        createMarkerCostaRicaCaliCoco()
        createMarkerCostaRicaCaliAlFis()
        createMarkerCostaRicaFloCoco()
        createMarkerCostaRicaFloAlfis()
        createMarkerHondurasCaliVolt()
        createMarkerHondurasFlorVolt()
    }

    private fun createMarkerElSalvadorCaliRansa() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates3 = LatLng(13.7835293470295, -89.20225766001776)
        val marker3: MarkerOptions =
            MarkerOptions().position(coordinates3).title("Almacenadora Ransa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker3)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerElSalvadorCaliNe() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates4 = LatLng(13.805556241227952, -89.23669697650517)
        val marker4: MarkerOptions =
            MarkerOptions().position(coordinates4).title("Almacenadora Nejapa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker4)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerElSalvadorCaliSanBar() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates5 = LatLng(13.705099451272222, -89.10084345817191)
        val marker5: MarkerOptions =
            MarkerOptions().position(coordinates5).title("Almacenadora San Bartolo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker5)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerElSalvadorCaliTrans() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates6 = LatLng(13.676110958826975, -89.20657941584241)
        val marker6: MarkerOptions =
            MarkerOptions().position(coordinates6).title("Almacenadora Transauto")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker6)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
        //Florida//El Salvador//
    }

    private fun createMarkerElSalvadorFloRansa() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates3 = LatLng(13.7835293470295, -89.20225766001776)
        val marker3: MarkerOptions =
            MarkerOptions().position(coordinates3).title("Almacenadora Ransa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker3)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerElSalvadorFloNe() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates4 = LatLng(13.805556241227952, -89.23669697650517)
        val marker4: MarkerOptions =
            MarkerOptions().position(coordinates4).title("Almacenadora Nejapa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker4)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerElSalvadorFloSanBar() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates5 = LatLng(13.705099451272222, -89.10084345817191)
        val marker5: MarkerOptions =
            MarkerOptions().position(coordinates5).title("Almacenadora San Bartolo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker5)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerElSalvadorFloTrans() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates6 = LatLng(13.676110958826975, -89.20657941584241)
        val marker6: MarkerOptions =
            MarkerOptions().position(coordinates6).title("Almacenadora Transauto")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker6)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //California//Guatemala//
    private fun createMarkerGuatemalaCaliCoalsa() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates9 = LatLng(14.575247346123108, -90.54153058685938)
        val marker9: MarkerOptions =
            MarkerOptions().position(coordinates9).title("Almacenadora Coalsa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker9)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerGuatemalaCaliCentralsa() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates10 = LatLng(14.580764072607524, -90.54232151569565)
        val marker10: MarkerOptions =
            MarkerOptions().position(coordinates10).title("Almacenadora Centralsa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker10)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerGuatemalaCaliStoTomas() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates11 = LatLng(15.694476370375993, -88.62075035916287)
        val marker11: MarkerOptions =
            MarkerOptions().position(coordinates11).title("Almacenadora Santo Tomas")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker11)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerGuatemalaCaliPtoBar() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates12 = LatLng(15.735773589990226, -88.60487846779328)
        val marker12: MarkerOptions =
            MarkerOptions().position(coordinates12).title("Almacenadora Puerto Barrios")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker12)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    ///Florida//Guatemala//
    private fun createMarkerGuatemalaFloCoalsa() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates9 = LatLng(14.575247346123108, -90.54153058685938)
        val marker9: MarkerOptions =
            MarkerOptions().position(coordinates9).title("Almacenadora Coalsa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker9)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerGuatemalaFloCentralsa() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates10 = LatLng(14.580764072607524, -90.54232151569565)
        val marker10: MarkerOptions =
            MarkerOptions().position(coordinates10).title("Almacenadora Centralsa")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker10)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerGuatemalaFloStoTomas() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates11 = LatLng(15.694476370375993, -88.62075035916287)
        val marker11: MarkerOptions =
            MarkerOptions().position(coordinates11).title("Almacenadora Santo Tomas")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker11)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerGuatemalaFloPtoBar() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates12 = LatLng(15.735773589990226, -88.60487846779328)
        val marker12: MarkerOptions =
            MarkerOptions().position(coordinates12).title("Almacenadora Puerto Barrios")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker12)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //California//Costa Rica/////////
    private fun createMarkerCostaRicaCaliCoco() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates13 = LatLng(9.986359315240188, -84.22312681525891)
        val marker13: MarkerOptions =
            MarkerOptions().position(coordinates13).title("Almacenadora El Coco")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker13)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    private fun createMarkerCostaRicaCaliAlFis() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates14 = LatLng(10.002740770986705, -84.1614552729314)
        val marker14: MarkerOptions =
            MarkerOptions().position(coordinates14).title("Almacen Fiscal Neutral")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker14)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    //Florida//Costa Rica/////////////////////
    private fun createMarkerCostaRicaFloCoco() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates13 = LatLng(9.986359315240188, -84.22312681525891)
        val marker13: MarkerOptions =
            MarkerOptions().position(coordinates13).title("Almacenadora El Coco")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker13)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    private fun createMarkerCostaRicaFloAlfis() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates14 = LatLng(10.002740770986705, -84.1614552729314)
        val marker14: MarkerOptions =
            MarkerOptions().position(coordinates14).title("Almacenadora Fiscal Neutral")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker14)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //California//Honduras
    private fun createMarkerHondurasCaliVolt() {
        val coordinates = LatLng(33.78050382614036, -118.20337330596534)
        val marker: MarkerOptions =
            MarkerOptions().position(coordinates).title("Bodegas Matus California")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates2 = LatLng(33.7551475743488, -118.21632928555647)
        val marker2: MarkerOptions =
            MarkerOptions().position(coordinates2).title("Puerto Long Beach")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates15 = LatLng(15.75749620992369, -87.49485221552523)
        val marker15: MarkerOptions =
            MarkerOptions().position(coordinates15).title("Deposito Temporal Votainer")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker)
        map.addMarker(marker2)
        map.addMarker(marker15)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }

    //Florida//Honduras
    private fun createMarkerHondurasFlorVolt() {
        val coordinates7 = LatLng(25.8707306238467, -80.36840935971841)
        val marker7: MarkerOptions =
            MarkerOptions().position(coordinates7).title("Bodegas Matus Florida")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        val coordinates8 = LatLng(26.122879315343337, -80.10738317364529)
        val marker8: MarkerOptions =
            MarkerOptions().position(coordinates8).title("Puerto Everglade")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconship))
        val coordinates15 = LatLng(13.676110958826975, -89.20657941584241)
        val marker15: MarkerOptions =
            MarkerOptions().position(coordinates15).title("Deposito Temporal")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconcrane))
        map.addMarker(marker7)
        map.addMarker(marker8)
        map.addMarker(marker15)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates7, 18f),
            4000,
            null
        )
    }


}