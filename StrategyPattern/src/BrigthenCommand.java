public class BrigthenCommand {

  //brigthen koalla 10
  //write koalla koallanew.jpg
  void run() {
      ImageModel koalla = database.get("koalla");
      BrithenOperation brithenOperation = new BrightenOperation();
      ImageModel newKoalla = brithenOperation.run(koalla);
      writeOperation(newKolla, "newKOalla.ppm");
  }

}
